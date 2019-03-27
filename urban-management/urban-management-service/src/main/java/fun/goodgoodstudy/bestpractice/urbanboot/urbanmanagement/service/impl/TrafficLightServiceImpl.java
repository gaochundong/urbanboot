package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.service.impl;

import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.contract.pojo.TrafficLightColor;
import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.mapper.TrafficLightMapper;
import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.service.TrafficLightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class TrafficLightServiceImpl implements TrafficLightService {
    @Autowired
    private TrafficLightMapper trafficLightMapper;

    @Override
    public Integer getCityTrafficLightCount(UUID cityId) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }

        Integer lightCount = trafficLightMapper.getCityTrafficLightCount(cityId.toString());
        log.info("获取城市[{}]交通信号灯数量[{}]", cityId, lightCount);
        return lightCount;
    }

    @Override
    public Integer getCityTrafficLightCountByColor(UUID cityId, TrafficLightColor color) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }
        if (color == null) {
            throw new IllegalArgumentException("信号灯颜色未指定");
        }

        Integer lightCount = trafficLightMapper.getCityTrafficLightCountByColor(cityId.toString(), color.getValue());
        log.info("获取城市[{}]交通信号灯颜色是[{}]的数量[{}]", cityId, color.getDescription(), lightCount);
        return lightCount;
    }
}