package ai.sangmado.urbanboot.urban.traffic.management.mapper;

import ai.sangmado.urbanboot.urban.traffic.management.entity.TrafficLightPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrafficLightMapper {

    List<TrafficLightPO> getCityTrafficLights(@Param("cityId") Long cityId);

    List<TrafficLightPO> getCityTrafficLightsWithColor(@Param("cityId") Long cityId, @Param("color") Integer color);

    Integer getCityTrafficLightCount(@Param("cityId") Long cityId);

    Integer getCityTrafficLightCountWithColor(@Param("cityId") Long cityId, @Param("color") Integer color);
}