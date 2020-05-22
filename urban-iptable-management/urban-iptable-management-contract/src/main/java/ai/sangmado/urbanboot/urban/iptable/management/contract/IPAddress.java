package ai.sangmado.urbanboot.urban.iptable.management.contract;

import lombok.Getter;
import lombok.Setter;

/**
 * IP地址
 */
@Getter
@Setter
public class IPAddress {

    private Long id;

    private Long parentId;

    private Integer level;

    private String name;

    private String pinyinPrefix;

    private String pinyin;

    private String extId;

    private String fullName;
}
