package ai.sangmado.urbanboot.urban.traffic.management.feign;

import ai.sangmado.urbanboot.urban.district.management.contract.City;
import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.contract.Province;
import ai.sangmado.urbanboot.urban.traffic.management.feign.config.CustomizedFeignClientsConfiguration;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "urban-district-management-app",
        contextId = "UrbanDistrictServiceFeign",
        configuration = CustomizedFeignClientsConfiguration.class)
public interface UrbanDistrictServiceFeign {
    /**
     * 查询省级区划列表
     *
     * @return 区划列表
     */
    @ApiOperation("查询省级区划列表")
    @GetMapping(path = "/urban/district/provinces", produces = "application/json")
    List<Province> getProvinces();

    /**
     * 查询省级区划
     *
     * @param provinceId 省ID
     * @return 省级区划
     */
    @ApiOperation("查询省级区划")
    @GetMapping(path = "/urban/district/provinces/{provinceId}", produces = "application/json")
    Province getProvinceById(
            @PathVariable("provinceId") @ApiParam(value = "省ID") Long provinceId);

    /**
     * 查询省级区划下辖市级区划列表
     *
     * @param provinceId 省ID
     * @return 区划列表
     */
    @ApiOperation("查询省级区划下辖市级区划列表")
    @GetMapping(path = "/urban/district/provinces/{provinceId}/cities", produces = "application/json")
    List<City> getProvinceCities(
            @PathVariable("provinceId") @ApiParam(value = "省ID") Long provinceId);

    /**
     * 查询市级区划
     *
     * @param cityId 市ID
     * @return 市级区划
     */
    @ApiOperation("查询市级区划")
    @GetMapping(path = "/urban/district/cities/{cityId}", produces = "application/json")
    City getCityById(
            @PathVariable("cityId") @ApiParam(value = "市ID") Long cityId);

    /**
     * 查询市级区划下辖区级区划列表
     *
     * @param cityId 市ID
     * @return 区划列表
     */
    @ApiOperation("查询市级区划下辖区级区划列表")
    @GetMapping(path = "/urban/district/cities/{cityId}/districts", produces = "application/json")
    List<District> getCityDistricts(
            @PathVariable("cityId") @ApiParam(value = "市ID") Long cityId);

    /**
     * 查询区级区划
     *
     * @param districtId 区ID
     * @return 区划
     */
    @ApiOperation("查询区级区划")
    @GetMapping(path = "/urban/district/districts/{districtId}", produces = "application/json")
    District getDistrict(
            @PathVariable("districtId") @ApiParam(value = "区ID") Long districtId);
}
