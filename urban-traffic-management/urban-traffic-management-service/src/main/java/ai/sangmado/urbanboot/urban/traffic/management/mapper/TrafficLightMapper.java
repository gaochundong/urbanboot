package ai.sangmado.urbanboot.urban.traffic.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TrafficLightMapper {

    Integer getCityTrafficLightCount(@Param("cityId") String cityId);

    Integer getCityTrafficLightCountWithColor(@Param("cityId") String cityId, @Param("color") Integer color);
}