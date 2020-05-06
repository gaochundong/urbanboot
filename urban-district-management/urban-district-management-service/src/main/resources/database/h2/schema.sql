drop table if exists district;

create table district
(
  id BIGINT(20) NOT NULL COMMENT '区划ID',
  parent_id BIGINT(20) NOT NULL COMMENT '父ID',
  level INT(11) NOT NULL COMMENT '层级',
  name VARCHAR(64) NOT NULL COMMENT '区划名称',
  pinyin_prefix VARCHAR(8) NOT NULL COMMENT '拼音前缀',
  pinyin VARCHAR(64) NOT NULL COMMENT '拼音',
  ext_id VARCHAR(255) NOT NULL COMMENT '扩展ID',
  full_name VARCHAR(255) NOT NULL COMMENT '详细名称',
  PRIMARY KEY (id)
);