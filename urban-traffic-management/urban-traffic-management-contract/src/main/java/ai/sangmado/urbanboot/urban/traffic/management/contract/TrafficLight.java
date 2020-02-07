package ai.sangmado.urbanboot.urban.traffic.management.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TrafficLight {

    private UUID cityId;

    private UUID id;

    private String name;

    private TrafficLightColor color;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdTime;
}
