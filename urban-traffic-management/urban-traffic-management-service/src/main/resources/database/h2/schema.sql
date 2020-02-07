drop table if exists city;

create table city
(
  id BIGINT(20) NOT NULL COMMENT '自增ID',
  city_id VARCHAR(36) NOT NULL COMMENT '城市ID',
  city_name VARCHAR(255) NOT NULL COMMENT '城市名称',
  PRIMARY KEY (id)
);

drop table if exists city_traffic_light;

create table city_traffic_light
(
  id BIGINT(20) NOT NULL COMMENT '自增ID',
  city_id VARCHAR(36) NOT NULL COMMENT '城市ID',
  light_id VARCHAR(36) NOT NULL COMMENT '信号灯ID',
  light_name VARCHAR(255) NOT NULL COMMENT '信号灯名称',
  light_color INT(11) NULL DEFAULT 0 COMMENT '信号灯颜色',
  created_time timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  PRIMARY KEY (id)
);