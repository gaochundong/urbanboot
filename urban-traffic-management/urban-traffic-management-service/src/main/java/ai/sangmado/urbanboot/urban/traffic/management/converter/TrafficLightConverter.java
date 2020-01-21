package ai.sangmado.urbanboot.urban.traffic.management.converter;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.entity.TrafficLightPO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {SimpleTypeConverter.class})
public interface TrafficLightConverter {

    List<TrafficLight> convertTrafficLightList(List<TrafficLightPO> from);

    TrafficLight convertTrafficLight(TrafficLightPO from);

    default UUID convertUUID(String from) {
        return UUID.fromString(from);
    }

    default String convertUUID(UUID from) {
        return from == null ? null : from.toString();
    }
}
