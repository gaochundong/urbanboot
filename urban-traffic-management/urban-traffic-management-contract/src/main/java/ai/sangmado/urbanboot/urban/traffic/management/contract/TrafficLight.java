package ai.sangmado.urbanboot.urban.traffic.management.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TrafficLight {

    private Long cityId;

    private UUID id;

    private String name;

    private TrafficLightColor color;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdTime;
}
