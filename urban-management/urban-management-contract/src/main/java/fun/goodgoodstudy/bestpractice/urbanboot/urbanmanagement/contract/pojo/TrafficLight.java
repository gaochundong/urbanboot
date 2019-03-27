package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.contract.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class TrafficLight {

    private UUID id;

    private String name;

    private TrafficLightColor color;
}
