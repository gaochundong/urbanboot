package ai.sangmado.urbanboot.urban.district.management.mapper;

import ai.sangmado.urbanboot.urban.district.management.entity.DistrictPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DistrictMapper {

    DistrictPO getDistrict(@Param("districtId") Long districtId);

    List<DistrictPO> getChildDistricts(@Param("parentId") Long parentId);

    List<DistrictPO> getDistrictsByLevel(@Param("level") Integer level);
}