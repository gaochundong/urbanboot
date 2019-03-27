package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.converter;

import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.contract.pojo.TrafficLightColor;
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