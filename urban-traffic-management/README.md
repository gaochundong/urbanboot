# Urban Traffic Management

城市交通管理系统

- contract 服务契约
- service  服务实现
- app      应用程序托管

## Docker

- docker build -t urban-traffic-management-app:latest --file ./urban-traffic-management/docker/Dockerfile .
- docker run -it -p 7200:7200/tcp urban-traffic-management-app:latest sh
- docker images
- docker ps
- docker exec -it c5c92af9ced6 sh

## H2 Database

- http://localhost:7200/h2-console

## Ping & Health

- curl http://localhost:7200
- curl http://localhost:7200/ping
- curl http://localhost:7200/health

## Swagger Doc

- http://localhost:7200/swagger-ui.html

## API Testing

- curl http://localhost:7200/urban/cities/903b5e45-bfe4-4549-804a-48f3e2d12f6b/traffic-lights-count
- curl http://localhost:7200/urban/cities/903b5e45-bfe4-4549-804a-48f3e2d12f6b/traffic-lights-count?color=red
- curl http://localhost:7200/urban/cities/903b5e45-bfe4-4549-804a-48f3e2d12f6b/traffic-lights-count?color=yellow
- curl http://localhost:7200/urban/cities/903b5e45-bfe4-4549-804a-48f3e2d12f6b/traffic-lights-count?color=green
