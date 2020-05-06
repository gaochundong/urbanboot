package ai.sangmado.urbanboot.urban.traffic.management.service;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;

import java.util.List;

public interface TrafficLightService {

    List<TrafficLight> getCityTrafficLights(Long cityId);

    List<TrafficLight> getCityTrafficLightsWithColor(Long cityId, TrafficLightColor color);

    Integer getCityTrafficLightCount(Long cityId);

    Integer getCityTrafficLightCountWithColor(Long cityId, TrafficLightColor color);
}
