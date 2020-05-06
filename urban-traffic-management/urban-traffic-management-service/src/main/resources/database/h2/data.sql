delete from city_traffic_light;

insert into city_traffic_light
(id, city_id, light_id, light_name, light_color, created_time)
values
(1, 2101, '20b84371-f302-4f61-a244-4f5e7ae20edb', '北京街1号灯', 1, '2020-01-01 23:00:00'),
(2, 2101, '935673b6-1667-4166-80a1-e93e31ce7015', '北京街2号灯', 1, '2020-01-01 23:00:00'),
(3, 2101, 'fd65432f-1961-45c6-bb3d-a8af4ece6fb5', '北京街3号灯', 2, '2020-01-01 23:00:00'),
(4, 2101, '2fce7737-f9bb-4c90-8e67-b08ff723b21a', '北京街4号灯', 3, '2020-01-01 23:00:00'),
(5, 2101, 'db3fff6c-31a2-4483-bc9f-c9bd7943ce9b', '北京街5号灯', 3, '2020-01-01 23:00:00');