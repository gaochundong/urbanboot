package ai.sangmado.urbanboot.urban.iptable.management.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IPAddressPO {

    private String ipStart;

    private String ipEnd;

    private String address;

    private String location;

    private String country;

    private String province;

    private String city;

    private String district;
}
