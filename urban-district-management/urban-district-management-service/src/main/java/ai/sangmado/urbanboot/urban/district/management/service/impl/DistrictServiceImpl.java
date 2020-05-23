package ai.sangmado.urbanboot.urban.district.management.service.impl;

import ai.sangmado.urbanboot.urban.common.exception.InvalidRequestParameterException;
import ai.sangmado.urbanboot.urban.district.management.contract.City;
import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.contract.Province;
import ai.sangmado.urbanboot.urban.district.management.converter.DistrictConverter;
import ai.sangmado.urbanboot.urban.district.management.entity.DistrictPO;
import ai.sangmado.urbanboot.urban.district.management.mapper.DistrictMapper;
import ai.sangmado.urbanboot.urban.district.management.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市区划服务
 */
@Slf4j
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private DistrictConverter districtConverter;

    private static final int LEVEL_OF_PROVINCE = 0;
    private static final int LEVEL_OF_CITY = 1;
    private static final int LEVEL_OF_DISTRICT = 2;

    @Override
    public Province getProvinceById(Long provinceId) {
        if (provinceId == null) {
            throw new InvalidRequestParameterException("provinceId", "省ID不能为空");
        }

        DistrictPO district = districtMapper.getDistrict(provinceId);

        // 校验层级
        if (district != null && district.getLevel() != LEVEL_OF_PROVINCE) district = null;

        log.info("获取省ID[{}]对应的省[{}]", provinceId, district == null ? "" : district.getName());
        return districtConverter.convertToProvince(district);
    }

    @Override
    public List<Province> getProvinces() {
        List<DistrictPO> districts = districtMapper.getDistrictsByLevel(LEVEL_OF_PROVINCE);
        log.info("获取省层级[{}]的省列表[{}]", LEVEL_OF_PROVINCE, districts.size());
        return districtConverter.convertToProvinceList(districts);
    }

    @Override
    public List<City> getProvinceCities(Long provinceId) {
        if (provinceId == null) {
            throw new InvalidRequestParameterException("provinceId", "省ID不能为空");
        }

        Province province = getProvinceById(provinceId);
        if (province == null) {
            throw new InvalidRequestParameterException("provinceId", "省ID不存在");
        }

        List<DistrictPO> districts = districtMapper.getChildDistricts(province.getId());
        log.info("获取省ID[{}]下辖的市列表[{}]", province.getId(), districts.size());
        return districtConverter.convertToCityList(districts);
    }

    @Override
    public City getCityById(Long cityId) {
        if (cityId == null) {
            throw new InvalidRequestParameterException("cityId", "市ID不能为空");
        }

        DistrictPO district = districtMapper.getDistrict(cityId);

        // 校验层级
        if (district != null && district.getLevel() != LEVEL_OF_CITY) district = null;

        log.info("获取市ID[{}]对应的市[{}]", cityId, district == null ? "" : district.getName());
        return districtConverter.convertToCity(district);
    }

    @Override
    public List<District> getCityDistricts(Long cityId) {
        if (cityId == null) {
            throw new InvalidRequestParameterException("cityId", "市ID不能为空");
        }

        City city = getCityById(cityId);
        if (city == null) {
            throw new InvalidRequestParameterException("cityId", "市ID不存在");
        }

        List<DistrictPO> districts = districtMapper.getChildDistricts(city.getId());
        log.info("获取市ID[{}]下辖的区列表[{}]", city.getId(), districts.size());
        return districtConverter.convertToDistrictList(districts);
    }

    @Override
    public District getDistrict(Long districtId) {
        if (districtId == null) {
            throw new InvalidRequestParameterException("districtId", "区ID不能为空");
        }

        DistrictPO district = districtMapper.getDistrict(districtId);

        // 校验层级
        if (district != null && district.getLevel() != LEVEL_OF_DISTRICT) district = null;

        log.info("获取区ID[{}]对应的区[{}]", districtId, district == null ? "" : district.getName());
        return districtConverter.convertToDistrict(district);
    }
}