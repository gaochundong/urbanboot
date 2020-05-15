package ai.sangmado.urbanboot.urban.district.management.converter;

import ai.sangmado.urbanboot.urban.district.management.contract.City;
import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.contract.Province;
import ai.sangmado.urbanboot.urban.district.management.entity.DistrictPO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistrictConverter {

    Province convertToProvince(DistrictPO from);

    List<Province> convertToProvinceList(List<DistrictPO> from);

    City convertToCity(DistrictPO from);

    List<City> convertToCityList(List<DistrictPO> from);

    District convertToDistrict(DistrictPO from);

    List<District> convertToDistrictList(List<DistrictPO> from);
}
