package ai.sangmado.urbanboot.urban.traffic.management.converter;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLight;
import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;
import ai.sangmado.urbanboot.urban.traffic.management.entity.TrafficLightPO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {SimpleTypeConverter.class})
public interface TrafficLightConverter {

    List<TrafficLight> convertTrafficLightList(List<TrafficLightPO> from);

    default TrafficLight convertTrafficLight(TrafficLightPO from) {
        TrafficLight to = new TrafficLight();

        to.setCityId(convertUUID(from.getCityId()));
        to.setId(convertUUID(from.getLightId()));
        to.setName(from.getLightName());
        to.setColor(TrafficLightColor.cast(from.getLightColor()));
        to.setCreatedTime(from.getCreatedTime());

        return to;
    }

    default UUID convertUUID(String from) {
        return UUID.fromString(from);
    }

    default String convertUUID(UUID from) {
        return from == null ? null : from.toString();
    }
}
