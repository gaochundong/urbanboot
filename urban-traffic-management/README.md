# Urban Traffic Management

城市交通管理系统

- contract 服务契约
- service  服务实现
- app      应用程序托管

## Docker

- cd urbanboot
- docker build -t urban-traffic-management-app:latest --file ./urban-traffic-management/docker/Dockerfile .
- docker images
- docker rmi --force $(docker images | grep "^<none>" | awk '{print $3}') 
- docker run --name urban-traffic-management-app -it --rm -p 7200:7200/tcp urban-traffic-management-app:latest
- docker ps
- docker exec -it urban-traffic-management-app sh
- docker exec -it urban-traffic-management-app sh -c "cat /opt/urbanboot/urban-traffic-management/logs/access.log"
- docker rm $(docker ps -a -q)

## H2 Database

- http://localhost:7200/h2-console

## Ping & Health

- curl http://localhost:7200
- curl http://localhost:7200/ping
- curl http://localhost:7200/health

## Swagger Doc

- http://localhost:7200/swagger-ui.html

## API Testing

- curl http://localhost:7200/urban/traffic/cities/2101/traffic-lights-count
- curl http://localhost:7200/urban/traffic/cities/2101/traffic-lights-count?color=red
- curl http://localhost:7200/urban/traffic/cities/2101/traffic-lights-count?color=yellow
- curl http://localhost:7200/urban/traffic/cities/2101/traffic-lights-count?color=green
