delete from city;

insert into city
(id, city_id, city_name)
values
(1, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', '北京市');

delete from city_traffic_light;

insert into city_traffic_light
(id, city_id, light_id, light_name, light_color, created_time)
values
(1, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', '20b84371-f302-4f61-a244-4f5e7ae20edb', '北太平桥1号灯', 1, '2020-01-01 23:00:00'),
(2, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', '935673b6-1667-4166-80a1-e93e31ce7015', '北太平桥2号灯', 1, '2020-01-01 23:00:00'),
(3, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', 'fd65432f-1961-45c6-bb3d-a8af4ece6fb5', '北太平桥3号灯', 2, '2020-01-01 23:00:00'),
(4, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', '2fce7737-f9bb-4c90-8e67-b08ff723b21a', '北太平桥4号灯', 3, '2020-01-01 23:00:00'),
(5, '903b5e45-bfe4-4549-804a-48f3e2d12f6b', 'db3fff6c-31a2-4483-bc9f-c9bd7943ce9b', '北太平桥5号灯', 3, '2020-01-01 23:00:00');