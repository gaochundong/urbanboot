package ai.sangmado.urbanboot.urban.traffic.management.service;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;

import java.util.List;
import java.util.UUID;

public interface TrafficLightService {

    List<TrafficLight> getCityTrafficLights(UUID cityId);

    List<TrafficLight> getCityTrafficLightsWithColor(UUID cityId, TrafficLightColor color);

    Integer getCityTrafficLightCount(UUID cityId);

    Integer getCityTrafficLightCountWithColor(UUID cityId, TrafficLightColor color);
}
