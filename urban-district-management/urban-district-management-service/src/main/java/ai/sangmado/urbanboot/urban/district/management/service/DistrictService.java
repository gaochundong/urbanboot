package ai.sangmado.urbanboot.urban.district.management.service;

import ai.sangmado.urbanboot.urban.district.management.contract.District;

import java.util.List;

/**
 * 城市区划服务
 */
public interface DistrictService {

    District getDistrict(Long districtId);

    List<District> getChildDistricts(Long parentId);

    List<District> getDistrictsByLevel(Integer level);
}
