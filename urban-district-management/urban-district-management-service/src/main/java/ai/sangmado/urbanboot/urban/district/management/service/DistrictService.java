package ai.sangmado.urbanboot.urban.district.management.service;

import ai.sangmado.urbanboot.urban.district.management.contract.City;
import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.contract.Province;

import java.util.List;

/**
 * 城市区划服务
 */
public interface DistrictService {

    Province getProvinceById(Long provinceId);

    List<Province> getProvinces();

    List<City> getProvinceCities(Long provinceId);

    City getCityById(Long cityId);

    List<District> getCityDistricts(Long cityId);

    District getDistrict(Long districtId);
}
