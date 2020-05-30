package ai.sangmado.urbanboot.urban.gateway.management.filters;

import ai.sangmado.urbanboot.urban.gateway.management.logging.StructuredRequestLog;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static ai.sangmado.urbanboot.urban.gateway.management.support.ServerWebExchangeAttributeAppender.*;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

@Slf4j
@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER + 3;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        setAttributeOfRequestBeginTime(exchange, System.currentTimeMillis());
        return chain.filter(exchange).doOnSuccessOrError((aVoid, ex) -> {
            setAttributeOfRequestEndTime(exchange, System.currentTimeMillis());
            loggingRespectingCommit(exchange);
        });
    }

    private void loggingRespectingCommit(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()) {
            logRequest(exchange);
        } else {
            response.beforeCommit(() -> {
                logRequest(exchange);
                return Mono.empty();
            });
        }
    }

    private void logRequest(ServerWebExchange exchange) {
        Set<URI> uris = exchange.getAttributeOrDefault(GATEWAY_ORIGINAL_REQUEST_URL_ATTR, Collections.emptySet());
        URI originalUri = (uris.isEmpty()) ? null : uris.iterator().next();
        originalUri = originalUri != null ? originalUri : exchange.getRequest().getURI();
        String httpMethod = exchange.getRequest().getMethodValue();
        String userAgent = exchange.getRequest().getHeaders().getFirst(HttpHeaders.USER_AGENT);
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        String host = exchange.getRequest().getHeaders().getFirst("X-Forwarded-Host");
        host = !Strings.isNullOrEmpty(host) ? host :
                exchange.getRequest().getHeaders().getFirst(HttpHeaders.HOST);
        String remoteAddress = exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");
        remoteAddress = !Strings.isNullOrEmpty(remoteAddress) ? remoteAddress :
                (exchange.getRequest().getRemoteAddress() == null
                        ? null : exchange.getRequest().getRemoteAddress().toString());
        String port = exchange.getRequest().getHeaders().getFirst("X-Forwarded-Port");

        HttpStatus responseStatus = exchange.getResponse().getStatusCode();
        String responseContentLength = exchange.getResponse().getHeaders().getFirst(HttpHeaders.CONTENT_LENGTH);
        String responseTransferEncoding = exchange.getResponse().getHeaders().getFirst(HttpHeaders.TRANSFER_ENCODING);

        Long requestBeginTime = getAttributeOfRequestBeginTime(exchange);
        Long requestEndTime = getAttributeOfRequestEndTime(exchange);

        StructuredRequestLog requestLog = StructuredRequestLog.builder()
                .requestBeginTime(requestBeginTime == null ? null : toEpochDateTime(requestBeginTime))
                .requestEndTime(requestEndTime == null ? null : toEpochDateTime(requestEndTime))
                .host(host)
                .remoteAddress(remoteAddress)
                .port(port)
                .userAgent(userAgent)
                .httpMethod(httpMethod)
                .originalUri(Objects.toString(originalUri, null))
                .routeId(route == null ? null : route.getId())
                .routeUri(Objects.toString(routeUri, null))
                .responseStatus(responseStatus == null ? null : responseStatus.value())
                .responseReasonPhrase(responseStatus == null ? null : responseStatus.getReasonPhrase())
                .responseContentLength(responseContentLength)
                .responseTransferEncoding(responseTransferEncoding)
                .build();

        if (responseStatus != null && responseStatus.is4xxClientError()) {
            log.warn(requestLog.toString());
        } else if (responseStatus != null && responseStatus.is5xxServerError()) {
            log.error(requestLog.toString());
        } else {
            log.info(requestLog.toString());
        }
    }

    private static LocalDateTime toEpochDateTime(Long epochMilliseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliseconds), ZoneId.of("UTC"));
    }
}