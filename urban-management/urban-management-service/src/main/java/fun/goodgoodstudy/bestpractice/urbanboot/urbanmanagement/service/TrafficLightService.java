package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.service;

import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.contract.pojo.TrafficLightColor;

import java.util.UUID;

public interface TrafficLightService {

    Integer getCityTrafficLightCount(UUID cityId);

    Integer getCityTrafficLightCountByColor(UUID cityId, TrafficLightColor color);
}
