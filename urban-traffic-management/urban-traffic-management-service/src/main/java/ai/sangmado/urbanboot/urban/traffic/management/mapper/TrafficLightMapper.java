package ai.sangmado.urbanboot.urban.traffic.management.mapper;

import ai.sangmado.urbanboot.urban.traffic.management.entity.TrafficLightPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrafficLightMapper {

    List<TrafficLightPO> getCityTrafficLights(@Param("cityId") String cityId);

    List<TrafficLightPO> getCityTrafficLightsWithColor(@Param("cityId") String cityId, @Param("color") Integer color);

    Integer getCityTrafficLightCount(@Param("cityId") String cityId);

    Integer getCityTrafficLightCountWithColor(@Param("cityId") String cityId, @Param("color") Integer color);
}