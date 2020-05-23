package ai.sangmado.urbanboot.urban.traffic.management.controller;

import ai.sangmado.urbanboot.urban.common.exception.InternalServerErrorException;
import ai.sangmado.urbanboot.urban.common.exception.InvalidRequestParameterException;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;
import ai.sangmado.urbanboot.urban.traffic.management.feign.UrbanDistrictServiceFeign;
import ai.sangmado.urbanboot.urban.traffic.management.feign.district.City;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市交通信号灯 REST API
 */
@Slf4j
@RestController
@Api(tags = {"城市交通信号灯 REST API"})
public class TrafficLightController {
    @Autowired
    private UrbanDistrictServiceFeign districtService;
    @Autowired
    private TrafficLightService trafficLightService;

    /**
     * 查询城市信号灯数量表
     *
     * @param cityId 城市ID
     * @param color  信号灯颜色(可选)
     * @return 信号灯数量表
     */
    @ApiOperation("查询城市信号灯数量")
    @GetMapping(path = "/urban/traffic/cities/{cityId}/traffic-lights-count", produces = "application/json")
    public Map<String, Integer> getCityTrafficLightCount(
            @PathVariable("cityId") @ApiParam(value = "城市ID") Long cityId,
            @RequestParam(value = "color", required = false) @ApiParam(value = "信号灯颜色") String color) {
        if (cityId == null) {
            throw new InvalidRequestParameterException("cityId", "城市ID不能为空");
        }

        try {
            City city = districtService.getCityById(cityId);
            if (city == null) {
                throw new InvalidRequestParameterException("cityId", "城市ID不存在");
            }

            final String TOTAL = "total";
            TrafficLightColor colorType = TrafficLightColor.parse(color);
            if (colorType != null) {
                // 查询指定颜色信号灯
                int countOfColor = trafficLightService.getCityTrafficLightCountWithColor(city.getId(), colorType);
                Map<String, Integer> result = new HashMap<>(1);
                result.put(colorType.name().toLowerCase(), countOfColor);
                return result;
            } else {
                // 查询所有信号灯
                int countOfTotal = trafficLightService.getCityTrafficLightCount(city.getId());
                int countOfRed = trafficLightService.getCityTrafficLightCountWithColor(city.getId(), TrafficLightColor.Red);
                int countOfYellow = trafficLightService.getCityTrafficLightCountWithColor(city.getId(), TrafficLightColor.Yellow);
                int countOfGreen = countOfTotal - countOfRed - countOfYellow;

                Map<String, Integer> result = new HashMap<>(4);
                result.put(TOTAL, countOfTotal);
                result.put(TrafficLightColor.Red.name().toLowerCase(), countOfRed);
                result.put(TrafficLightColor.Yellow.name().toLowerCase(), countOfYellow);
                result.put(TrafficLightColor.Green.name().toLowerCase(), countOfGreen);
                return result;
            }
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
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
            throw new InvalidRequestParameterException("cityId", "城市ID不能为空");
        }

        try {
            City city = districtService.getCityById(cityId);
            if (city == null) {
                throw new InvalidRequestParameterException("cityId", "城市ID不存在");
            }

            TrafficLightColor colorType = TrafficLightColor.parse(color);
            if (colorType != null) {
                // 查询指定颜色信号灯
                return trafficLightService.getCityTrafficLightsWithColor(city.getId(), colorType);
            } else {
                // 查询所有信号灯
                return trafficLightService.getCityTrafficLights(city.getId());
            }
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }
}
