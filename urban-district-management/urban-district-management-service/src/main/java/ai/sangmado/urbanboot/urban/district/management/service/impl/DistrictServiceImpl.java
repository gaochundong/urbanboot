package ai.sangmado.urbanboot.urban.district.management.service.impl;

import ai.sangmado.urbanboot.urban.district.management.contract.District;
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

    @Override
    public District getDistrict(Long districtId) {
        if (districtId == null) {
            throw new IllegalArgumentException("区划ID不能为空");
        }

        DistrictPO district = districtMapper.getDistrict(districtId);
        log.info("获取区划ID[{}]对应的区划[{}]", districtId, district == null ? "" : district.getName());
        return districtConverter.convert(district);
    }

    @Override
    public List<District> getChildDistricts(Long parentId) {
        if (parentId == null) {
            throw new IllegalArgumentException("父ID不能为空");
        }

        List<DistrictPO> districts = districtMapper.getChildDistricts(parentId);
        log.info("获取父ID[{}]下辖的区划列表[{}]", parentId, districts.size());
        return districtConverter.convertList(districts);
    }

    @Override
    public List<District> getDistrictsByLevel(Integer level) {
        if (level == null) {
            throw new IllegalArgumentException("区划层级不能为空");
        }

        List<DistrictPO> districts = districtMapper.getDistrictsByLevel(level);
        log.info("获取区划层级[{}]的区划列表[{}]", level, districts.size());
        return districtConverter.convertList(districts);
    }
}