package ai.sangmado.urbanboot.urban.district.management.controller;

import ai.sangmado.urbanboot.urban.common.exception.InternalServerErrorException;
import ai.sangmado.urbanboot.urban.district.management.contract.City;
import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.contract.Province;
import ai.sangmado.urbanboot.urban.district.management.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
     * 查询省级区划列表
     *
     * @return 区划列表
     */
    @ApiOperation("查询省级区划列表")
    @GetMapping(path = "/urban/district/provinces", produces = "application/json")
    public List<Province> getProvinces() {
        try {
            log.info("查询省级区划列表");
            return districtService.getProvinces();
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 查询省级区划
     *
     * @param provinceId 省ID
     * @return 省级区划
     */
    @ApiOperation("查询省级区划")
    @GetMapping(path = "/urban/district/provinces/{provinceId}", produces = "application/json")
    public Province getProvinceById(
            @PathVariable("provinceId") @ApiParam(value = "省ID") Long provinceId) {
        try {
            log.info("查询省级区划, 省ID[{}]", provinceId);
            return districtService.getProvinceById(provinceId);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 查询省级区划下辖市级区划列表
     *
     * @param provinceId 省ID
     * @return 区划列表
     */
    @ApiOperation("查询省级区划下辖市级区划列表")
    @GetMapping(path = "/urban/district/provinces/{provinceId}/cities", produces = "application/json")
    public List<City> getProvinceCities(
            @PathVariable("provinceId") @ApiParam(value = "省ID") Long provinceId) {
        try {
            log.info("查询省级区划下辖市级区划列表, 省ID[{}]", provinceId);
            return districtService.getProvinceCities(provinceId);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 查询市级区划
     *
     * @param cityId 市ID
     * @return 市级区划
     */
    @ApiOperation("查询市级区划")
    @GetMapping(path = "/urban/district/cities/{cityId}", produces = "application/json")
    public City getCityById(
            @PathVariable("cityId") @ApiParam(value = "市ID") Long cityId) {
        try {
            log.info("查询市级区划, 市ID[{}]", cityId);
            return districtService.getCityById(cityId);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 查询市级区划下辖区级区划列表
     *
     * @param cityId 市ID
     * @return 区划列表
     */
    @ApiOperation("查询市级区划下辖区级区划列表")
    @GetMapping(path = "/urban/district/cities/{cityId}/districts", produces = "application/json")
    public List<District> getCityDistricts(
            @PathVariable("cityId") @ApiParam(value = "市ID") Long cityId) {
        try {
            log.info("查询市级区划下辖区级区划列表, 市ID[{}]", cityId);
            return districtService.getCityDistricts(cityId);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 查询区级区划
     *
     * @param districtId 区ID
     * @return 区划
     */
    @ApiOperation("查询区级区划")
    @GetMapping(path = "/urban/district/districts/{districtId}", produces = "application/json")
    public District getDistrict(
            @PathVariable("districtId") @ApiParam(value = "区ID") Long districtId) {
        try {
            log.info("查询区级区划, 区ID[{}]", districtId);
            return districtService.getDistrict(districtId);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }
}
