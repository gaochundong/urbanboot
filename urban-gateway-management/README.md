# Urban Gateway Management

城市智能网关系统

## Docker

- cd urbanboot
- docker build -t urban-gateway-management-app:latest --file ./urban-gateway-management/docker/Dockerfile .
- docker images
- docker rmi --force $(docker images | grep "^<none>" | awk '{print $3}') 
- docker run --name urban-gateway-management-app -it --rm -p 7200:7200/tcp urban-gateway-management-app:latest
- docker ps
- docker exec -it urban-gateway-management-app sh
- docker exec -it urban-gateway-management-app sh -c "cat /opt/urbanboot/urban-gateway-management/logs/access.log"
- docker rm $(docker ps -a -q)

## Ping & Health

- curl http://localhost:7200
- curl http://localhost:7200/ping
- curl http://localhost:7200/health
