package ai.sangmado.urbanboot.urban.traffic.management.contract;

import lombok.Data;

import java.util.UUID;

@Data
public class TrafficLight {

    private UUID id;

    private String name;

    private TrafficLightColor color;
}
