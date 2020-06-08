# Urban District Management

城市区划管理服务

- contract 服务契约
- service  服务实现
- app      应用程序托管

## Docker

```bash
cd urbanboot
docker build -t urban-district-management-app:latest --file ./urban-district-management/docker/Dockerfile .
docker images
docker rmi --force $(docker images | grep "^<none>" | awk '{print $3}') 
docker run --name urban-district-management-app -it --rm -p 7200:7200/tcp urban-district-management-app:latest
docker ps
docker exec -it urban-district-management-app sh
docker exec -it urban-district-management-app sh -c "cat /opt/urbanboot/urban-district-management/logs/access.log"
docker rm $(docker ps -a -q)
```

## H2 Database

```bash
http://localhost:7200/h2-console
```

## Ping & Health

```bash
curl http://localhost:7200
curl http://localhost:7200/ping
curl http://localhost:7200/health
```

## Swagger Doc

```bash
http://localhost:7200/swagger-ui.html
```

## API Testing

```bash
curl http://localhost:7200/urban/district/provinces
curl http://localhost:7200/urban/district/provinces/21
curl http://localhost:7200/urban/district/provinces/21/cities
curl http://localhost:7200/urban/district/cities/2101
curl http://localhost:7200/urban/district/cities/2101/districts
curl http://localhost:7200/urban/district/districts/210103
```
