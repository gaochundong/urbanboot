package ai.sangmado.urbanboot.urban.traffic.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TrafficLightPO {

    private Long cityId;

    private String lightId;

    private String lightName;

    private Integer lightColor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdTime;
}
