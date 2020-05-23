package ai.sangmado.urbanboot.urban.iptable.management.mapper;

import ai.sangmado.urbanboot.urban.iptable.management.entity.IPAddressPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPAddressMapper {

    IPAddressPO queryIPAddress(@Param("stringIPAddress") String stringIPAddress);
}