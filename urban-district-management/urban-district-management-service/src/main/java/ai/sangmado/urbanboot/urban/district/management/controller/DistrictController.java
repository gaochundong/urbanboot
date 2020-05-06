package ai.sangmado.urbanboot.urban.district.management.controller;

import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 城市区划 REST API
 */
@Slf4j
@RestController
@Api(tags = {"城市区划 REST API"})
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    /**
     * 根据区划ID获取区划信息
     *
     * @return 区划
     */
    @ApiOperation("根据区划ID获取区划信息")
    @GetMapping(path = "/urban/district/districts/{districtId}", produces = "application/json")
    public District getDistrict(
            @PathVariable("districtId") @ApiParam(value = "区划ID") Long districtId) {
        return districtService.getDistrict(districtId);
    }

    /**
     * 查询省级区划
     *
     * @return 区划列表
     */
    @ApiOperation("查询省级区划")
    @GetMapping(path = "/urban/district/provinces", produces = "application/json")
    public List<District> getProvinces() {
        final Integer provinceDistrictLevel = 0;
        return districtService.getDistrictsByLevel(provinceDistrictLevel);
    }

    /**
     * 查询省级区划下辖市级区划
     *
     * @return 区划列表
     */
    @ApiOperation("查询省级区划下辖市级区划")
    @GetMapping(path = "/urban/district/provinces/{provinceId}/cities", produces = "application/json")
    public List<District> getProvinceCities(
            @PathVariable("provinceId") @ApiParam(value = "省ID") Long provinceId) {
        return districtService.getChildDistricts(provinceId);
    }

    /**
     * 查询市级区划下辖区级区划
     *
     * @return 区划列表
     */
    @ApiOperation("查询市级区划下辖区级区划")
    @GetMapping(path = "/urban/district/cities/{cityId}/districts", produces = "application/json")
    public List<District> getCityDistricts(
            @PathVariable("cityId") @ApiParam(value = "市ID") Long cityId) {
        return districtService.getChildDistricts(cityId);
    }
}
