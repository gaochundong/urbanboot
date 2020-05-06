package ai.sangmado.urbanboot.urban.district.management.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictPO {

    private Long id;

    private Long parentId;

    private Integer level;

    private String name;

    private String pinyinPrefix;

    private String pinyin;

    private String extId;

    private String fullName;
}
