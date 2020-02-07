package ai.sangmado.urbanboot.urban.traffic.management.service.impl;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;
import ai.sangmado.urbanboot.urban.traffic.management.converter.TrafficLightConverter;
import ai.sangmado.urbanboot.urban.traffic.management.entity.TrafficLightPO;
import ai.sangmado.urbanboot.urban.traffic.management.mapper.TrafficLightMapper;
import ai.sangmado.urbanboot.urban.traffic.management.service.TrafficLightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 交通信号灯服务
 */
@Slf4j
@Service
public class TrafficLightServiceImpl implements TrafficLightService {
    @Autowired
    private TrafficLightMapper trafficLightMapper;
    @Autowired
    private TrafficLightConverter trafficLightConverter;

    /**
     * 查询城市信号灯列表
     *
     * @param cityId 城市ID
     * @return 信号灯列表
     */
    @Override
    public List<TrafficLight> getCityTrafficLights(UUID cityId) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }

        List<TrafficLightPO> lights = trafficLightMapper.getCityTrafficLights(cityId.toString());
        log.info("获取城市[{}]交通信号灯列表[{}]", cityId, lights.size());
        return trafficLightConverter.convertTrafficLightList(lights);
    }

    /**
     * 查询城市信号灯列表
     *
     * @param cityId 城市ID
     * @param color  信号灯颜色
     * @return 信号灯列表
     */
    @Override
    public List<TrafficLight> getCityTrafficLightsWithColor(UUID cityId, TrafficLightColor color) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }
        if (color == null) {
            throw new IllegalArgumentException("信号灯颜色未指定");
        }

        List<TrafficLightPO> lights = trafficLightMapper.getCityTrafficLightsWithColor(cityId.toString(), color.getValue());
        log.info("获取城市[{}]交通信号灯颜色是[{}]的列表[{}]", cityId, color.getDescription(), lights.size());
        return trafficLightConverter.convertTrafficLightList(lights);
    }

    /**
     * 获取指定城市交通信号灯数量
     *
     * @param cityId 城市ID
     * @return 交通信号灯数量
     */
    @Override
    public Integer getCityTrafficLightCount(UUID cityId) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }

        Integer lightCount = trafficLightMapper.getCityTrafficLightCount(cityId.toString());
        log.info("获取城市[{}]交通信号灯数量[{}]", cityId, lightCount);
        return lightCount;
    }

    /**
     * 获取指定城市指定颜色的交通信号灯数量
     *
     * @param cityId 城市ID
     * @param color  信号灯颜色
     * @return 信号灯数量
     */
    @Override
    public Integer getCityTrafficLightCountWithColor(UUID cityId, TrafficLightColor color) {
        if (cityId == null) {
            throw new IllegalArgumentException("城市ID不能为空");
        }
        if (color == null) {
            throw new IllegalArgumentException("信号灯颜色未指定");
        }

        Integer lightCount = trafficLightMapper.getCityTrafficLightCountWithColor(cityId.toString(), color.getValue());
        log.info("获取城市[{}]交通信号灯颜色是[{}]的数量[{}]", cityId, color.getDescription(), lightCount);
        return lightCount;
    }
}