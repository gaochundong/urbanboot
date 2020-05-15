package ai.sangmado.urbanboot.urban.gateway.management.support;

import com.google.common.base.Strings;
import org.springframework.web.server.ServerWebExchange;

import static ai.sangmado.urbanboot.urban.gateway.management.support.ServerWebExchangeAttributeExtraDefinition.X_HEADER_OF_REQUEST_BEGIN_TIME;
import static ai.sangmado.urbanboot.urban.gateway.management.support.ServerWebExchangeAttributeExtraDefinition.X_HEADER_OF_REQUEST_END_TIME;

public final class ServerWebExchangeAttributeAppender {

    /**
     * 属性名：请求开始时间
     */
    public static final String ATTRIBUTE_OF_REQUEST_BEGIN_TIME = qualify(X_HEADER_OF_REQUEST_BEGIN_TIME);
    /**
     * 属性名：请求结束时间
     */
    public static final String ATTRIBUTE_OF_REQUEST_END_TIME = qualify(X_HEADER_OF_REQUEST_END_TIME);

    private static String qualify(String attributeName) {
        return ServerWebExchangeAttributeAppender.class.getName() + "." + attributeName;
    }

    public static void addAttribute(ServerWebExchange exchange, String key, String value) {
        exchange.getAttributes().put(key, value);
    }

    public static void setAttributeOfRequestBeginTime(ServerWebExchange exchange, Long epochMillis) {
        addAttribute(exchange, ATTRIBUTE_OF_REQUEST_BEGIN_TIME, epochMillis == null ? null : epochMillis.toString());
    }

    public static Long getAttributeOfRequestBeginTime(ServerWebExchange exchange) {
        String value = exchange.getAttribute(ATTRIBUTE_OF_REQUEST_BEGIN_TIME);
        return Strings.isNullOrEmpty(value) ? null : Long.parseLong(value);
    }

    public static void setAttributeOfRequestEndTime(ServerWebExchange exchange, Long epochMillis) {
        addAttribute(exchange, ATTRIBUTE_OF_REQUEST_END_TIME, epochMillis == null ? null : epochMillis.toString());
    }

    public static Long getAttributeOfRequestEndTime(ServerWebExchange exchange) {
        String value = exchange.getAttribute(ATTRIBUTE_OF_REQUEST_END_TIME);
        return Strings.isNullOrEmpty(value) ? null : Long.parseLong(value);
    }
}