package ai.sangmado.urbanboot.urban.traffic.management.feign.district;

import lombok.Getter;
import lombok.Setter;

/**
 * 市
 *
 * @implNote 由于没有可以deploy的maven库可用，则先采用代码复制方式，实际引用库即可
 */
@Getter
@Setter
public class City {

    private Long id;

    private Long parentId;

    private Integer level;

    private String name;

    private String pinyinPrefix;

    private String pinyin;

    private String extId;

    private String fullName;
}
