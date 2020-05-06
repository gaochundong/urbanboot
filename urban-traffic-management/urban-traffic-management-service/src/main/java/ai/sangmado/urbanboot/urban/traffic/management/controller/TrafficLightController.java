package ai.sangmado.urbanboot.urban.traffic.management.controller;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;
import ai.sangmado.urbanboot.urban.traffic.management.exception.BadRequestException;
import ai.sangmado.urbanboot.urban.traffic.management.service.TrafficLightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 城市交通信号灯 REST API
 */
@Slf4j
@RestController
@Api(tags = {"城市交通信号灯 REST API"})
public class TrafficLightController {
    @Autowired
    private TrafficLightService trafficLightService;

    /**
     * 查询城市信号灯数量
     *
     * @param cityId 城市ID
     * @param color  信号灯颜色(可选)
     * @return 信号灯数量
     */
    @ApiOperation("查询城市信号灯数量")
    @GetMapping(path = "/urban/traffic/cities/{cityId}/traffic-lights-count", produces = "application/json")
    public Integer getCityTrafficLightCount(
            @PathVariable("cityId") @ApiParam(value = "城市ID") Long cityId,
            @RequestParam(value = "color", required = false) @ApiParam(value = "信号灯颜色") String color) {
        if (cityId == null) {
            throw new BadRequestException("城市ID不能为空");
        }

        TrafficLightColor colorType = TrafficLightColor.parse(color);
        if (colorType == null) {
            // 查询所有信号灯
            return trafficLightService.getCityTrafficLightCount(cityId);
        } else {
            // 查询指定颜色信号灯
            return trafficLightService.getCityTrafficLightCountWithColor(cityId, colorType);
        }
    }

    /**
     * 查询城市信号灯列表
     *
     * @param cityId 城市ID
     * @param color  信号灯颜色(可选)
     * @return 信号灯列表
     */
    @ApiOperation("查询城市信号灯列表")
    @GetMapping(path = "/urban/traffic/cities/{cityId}/traffic-lights", produces = "application/json")
    public List<TrafficLight> getCityTrafficLights(
            @PathVariable("cityId") @ApiParam(value = "城市ID") Long cityId,
            @RequestParam(value = "color", required = false) @ApiParam(value = "信号灯颜色") String color) {
        if (cityId == null) {
            throw new BadRequestException("城市ID不能为空");
        }

        TrafficLightColor colorType = TrafficLightColor.parse(color);
        if (colorType == null) {
            // 查询所有信号灯
            return trafficLightService.getCityTrafficLights(cityId);
        } else {
            // 查询指定颜色信号灯
            return trafficLightService.getCityTrafficLightsWithColor(cityId, colorType);
        }
    }
}
