drop table if exists ip_address;

create table ip_address
(
  ip_start VARCHAR(20) NOT NULL COMMENT 'IP地址起始',
  ip_end VARCHAR(20) DEFAULT NULL COMMENT 'IP地址结束',
  address VARCHAR(200) DEFAULT NULL COMMENT '地址',
  location VARCHAR(200) DEFAULT NULL COMMENT '位置',
  country VARCHAR(60) DEFAULT NULL COMMENT '国家',
  province VARCHAR(60) DEFAULT NULL COMMENT '省',
  city VARCHAR(60) DEFAULT NULL COMMENT '城市',
  district VARCHAR(255) DEFAULT NULL COMMENT '区'
);

create INDEX ip_range on ip_address(ip_start, ip_end);

CREATE ALIAS INET_ATON FOR "ai.sangmado.urbanboot.urban.iptable.management.h2functions.IPAddressDefinedFunction.toNumeric";
CREATE ALIAS INET_NTOA FOR "ai.sangmado.urbanboot.urban.iptable.management.h2functions.IPAddressDefinedFunction.toString";
