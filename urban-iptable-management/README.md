# Urban IPTable Management

城市IP地址查询服务

- contract 服务契约
- service  服务实现
- app      应用程序托管

## Docker

- cd urbanboot
- docker build -t urban-iptable-management-app:latest --file ./urban-iptable-management/docker/Dockerfile .
- docker images
- docker rmi --force $(docker images | grep "^<none>" | awk '{print $3}') 
- docker run --name urban-iptable-management-app -it --rm -p 7200:7200/tcp urban-iptable-management-app:latest
- docker ps
- docker exec -it urban-iptable-management-app sh
- docker exec -it urban-iptable-management-app sh -c "cat /opt/urbanboot/urban-iptable-management/logs/access.log"
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

- curl -s http://localhost:7200/urban/iptable/ip-address?ip=1.0.4.0 | jq
- curl -s http://localhost:7200/urban/iptable/ip-address-list?ipList=1.0.4.0,1.63.12.255 | jq
