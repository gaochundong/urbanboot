package ai.sangmado.urbanboot.urban.iptable.management.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

/**
 * IP地址
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IPAddress {

    private String ipStart;

    private String ipEnd;

    private String address;

    private String location;

    private String country;

    private String province;

    private String city;

    private String district;
}
