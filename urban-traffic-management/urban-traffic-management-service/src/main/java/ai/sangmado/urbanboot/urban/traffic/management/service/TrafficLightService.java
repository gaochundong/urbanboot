package ai.sangmado.urbanboot.urban.traffic.management.service;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;

import java.util.UUID;

public interface TrafficLightService {

    Integer getCityTrafficLightCount(UUID cityId);

    Integer getCityTrafficLightCountWithColor(UUID cityId, TrafficLightColor color);
}