package ai.sangmado.urbanboot.urban.iptable.management.service;

import ai.sangmado.urbanboot.urban.iptable.management.contract.IPAddress;

import java.util.List;

/**
 * IP地址查询服务
 */
public interface IPAddressService {

    IPAddress searchIPAddress(String stringIPAddress);

    List<IPAddress> searchIPAddressList(List<String> stringIPAddressList);
}
