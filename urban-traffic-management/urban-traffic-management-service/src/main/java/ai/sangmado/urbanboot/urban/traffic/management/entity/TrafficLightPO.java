package ai.sangmado.urbanboot.urban.traffic.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrafficLightPO {

    private String cityId;

    private String lightId;

    private String lightName;

    private Integer lightColor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdTime;
}
