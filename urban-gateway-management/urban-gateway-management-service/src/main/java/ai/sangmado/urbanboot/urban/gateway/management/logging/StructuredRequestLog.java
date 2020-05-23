package ai.sangmado.urbanboot.urban.gateway.management.logging;

import ai.sangmado.urbanboot.urban.common.utils.ISO8601DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StructuredRequestLog {
    /**
     * 请求开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime requestBeginTime;
    /**
     * 请求结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime requestEndTime;
    /**
     * 请求主机名
     */
    private String host;
    /**
     * 请求源地址
     */
    private String remoteAddress;
    /**
     * 请求端口
     */
    private String port;
    /**
     * 请求 UserAgent
     */
    private String userAgent;
    /**
     * 请求 HTTP Method
     */
    private String httpMethod;
    /**
     * 请求路径
     */
    private String originalUri;
    /**
     * 路由ID
     */
    private String routeId;
    /**
     * 路由路径
     */
    private String routeUri;
    /**
     * 响应码
     */
    private Integer responseStatus;
    /**
     * 响应原因
     */
    private String responseReasonPhrase;
    /**
     * 响应内容长度 (可选)
     */
    private String responseContentLength;
    /**
     * 响应内容传输方式 (可选)
     */
    private String responseTransferEncoding;

    @Override
    public String toString() {
        String format = "request " +
                "from remote address [%s] " +
                "on host [%s] " +
                "with port [%s] " +
                "with agent [%s] " +
                "fired request [%s %s] " +
                "at time [%s] " +
                "is routed to [%s] " +
                "with uri [%s] " +
                "then responded [%s %s] " +
                "and length [%s] " +
                "with rt [%s ms] ";
        return String.format(format,
                Objects.toString(remoteAddress, ""),
                Objects.toString(host, ""),
                Objects.toString(port, ""),
                Objects.toString(userAgent, ""),
                Objects.toString(httpMethod, ""), Objects.toString(originalUri, ""),
                requestBeginTime == null ? "" : ISO8601DateTime.format(requestBeginTime),
                Objects.toString(routeId, ""),
                Objects.toString(routeUri, ""),
                Objects.toString(responseStatus, ""), Objects.toString(responseReasonPhrase, ""),
                Objects.toString(responseContentLength, Objects.toString(responseTransferEncoding, "")),
                (!(requestBeginTime != null && requestEndTime != null) ? "" : Duration.between(requestBeginTime, requestEndTime).toMillis())
        );
    }
}