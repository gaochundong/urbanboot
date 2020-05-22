package ai.sangmado.urbanboot.urban.iptable.management.controller;

import ai.sangmado.urbanboot.urban.iptable.management.contract.IPAddress;
import ai.sangmado.urbanboot.urban.iptable.management.exception.InternalServerErrorException;
import ai.sangmado.urbanboot.urban.iptable.management.service.IPAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

/**
 * IP地址查询 REST API
 */
@Slf4j
@RestController
@Api(tags = {"IP地址查询 REST API"})
public class IPAddressController {
    @Autowired
    private IPAddressService ipAddressService;

    /**
     * 查询IP地址
     *
     * @param ip IP地址
     * @return IP地址
     */
    @ApiOperation("查询IP地址")
    @GetMapping(path = "/urban/iptable/ip-address", produces = "application/json")
    public IPAddress searchIPAddress(
            @RequestParam("ip") @ApiParam(value = "IP地址") String ip) {
        try {
            return ipAddressService.searchIPAddress(ip);
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }

    /**
     * 批量查询IP地址列表
     *
     * @param ipList IP地址列表(使用','分割)
     * @return IP地址列表
     */
    @ApiOperation("批量查询IP地址列表")
    @GetMapping(path = "/urban/iptable/ip-address-list", produces = "application/json")
    public List<IPAddress> searchIPAddressList(
            @RequestParam("ipList") @ApiParam(value = "IP地址列表(使用','分割)") String ipList) {
        try {
            return ipAddressService.searchIPAddressList(
                    ipList == null ? null : Arrays.asList(ipList.split(",")));
        } catch (ResponseStatusException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new InternalServerErrorException();
        }
    }
}
