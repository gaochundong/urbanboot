package ai.sangmado.urbanboot.urban.iptable.management.converter;

import ai.sangmado.urbanboot.urban.iptable.management.contract.IPAddress;
import ai.sangmado.urbanboot.urban.iptable.management.entity.IPAddressPO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPAddressConverter {

    IPAddress convertToIPAddress(IPAddressPO from);

    List<IPAddress> convertToIPAddressList(List<IPAddressPO> from);
}
