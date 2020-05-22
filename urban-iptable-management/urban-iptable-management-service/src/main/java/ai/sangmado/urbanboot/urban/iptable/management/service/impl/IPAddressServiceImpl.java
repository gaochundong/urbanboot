package ai.sangmado.urbanboot.urban.iptable.management.service.impl;

import ai.sangmado.urbanboot.urban.iptable.management.contract.IPAddress;
import ai.sangmado.urbanboot.urban.iptable.management.converter.IPAddressConverter;
import ai.sangmado.urbanboot.urban.iptable.management.entity.IPAddressPO;
import ai.sangmado.urbanboot.urban.iptable.management.exception.InvalidRequestParameterException;
import ai.sangmado.urbanboot.urban.iptable.management.mapper.IPAddressMapper;
import ai.sangmado.urbanboot.urban.iptable.management.service.IPAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IP地址查询服务
 */
@Slf4j
@Service
public class IPAddressServiceImpl implements IPAddressService {
    @Autowired
    private IPAddressMapper ipAddressMapper;
    @Autowired
    private IPAddressConverter ipAddressConverter;

    @Override
    public IPAddress searchIPAddress(String stringIPAddress) {
        if (stringIPAddress == null || stringIPAddress.length() == 0) {
            throw new InvalidRequestParameterException("stringIPAddress", "IP地址不能为空");
        }

        IPAddressPO ip = ipAddressMapper.queryIPAddress(stringIPAddress);
        log.info("查询IP地址[{}]相关信息[{}]", stringIPAddress, ip == null ? "" : ip.toString());
        return ipAddressConverter.convertToIPAddress(ip);
    }

    @Override
    public List<IPAddress> searchIPAddressList(List<String> stringIPAddressList) {
        if (stringIPAddressList == null || stringIPAddressList.size() == 0) {
            throw new InvalidRequestParameterException("stringIPAddressList", "IP地址列表不能为空");
        }

        List<IPAddressPO> ipList = ipAddressMapper.queryIPAddressList(stringIPAddressList);
        log.info("批量查询IP地址[{}]匹配数量[{}]", stringIPAddressList.size(), ipList == null ? 0 : ipList.size());
        return ipAddressConverter.convertToIPAddressList(ipList);
    }
}