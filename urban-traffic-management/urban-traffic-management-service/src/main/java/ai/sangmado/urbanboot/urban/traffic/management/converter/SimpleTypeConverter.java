package ai.sangmado.urbanboot.urban.traffic.management.converter;

import ai.sangmado.urbanboot.urban.traffic.management.contract.TrafficLightColor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleTypeConverter {

    default TrafficLightColor convertTrafficLightColor(Integer from) {
        return TrafficLightColor.cast(from);
    }

    default Integer convertTrafficLightColor(TrafficLightColor from) {
        return from == null ? null : from.getValue();
    }
}