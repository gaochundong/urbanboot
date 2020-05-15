package ai.sangmado.urbanboot.urban.district.management.contract;

import lombok.Getter;
import lombok.Setter;

/**
 * 市
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
