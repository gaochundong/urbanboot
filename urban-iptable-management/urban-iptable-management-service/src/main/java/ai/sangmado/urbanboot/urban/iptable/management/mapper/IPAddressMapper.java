package ai.sangmado.urbanboot.urban.iptable.management.mapper;

import ai.sangmado.urbanboot.urban.iptable.management.entity.IPAddressPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IPAddressMapper {

    IPAddressPO queryIPAddress(@Param("stringIPAddress") String stringIPAddress);

    List<IPAddressPO> queryIPAddressList(@Param("stringIPAddressList") List<String> stringIPAddressList);
}