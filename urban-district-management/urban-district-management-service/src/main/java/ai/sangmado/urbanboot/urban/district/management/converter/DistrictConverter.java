package ai.sangmado.urbanboot.urban.district.management.converter;

import ai.sangmado.urbanboot.urban.district.management.contract.District;
import ai.sangmado.urbanboot.urban.district.management.entity.DistrictPO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistrictConverter {

    District convert(DistrictPO from);

    List<District> convertList(List<DistrictPO> from);
}
