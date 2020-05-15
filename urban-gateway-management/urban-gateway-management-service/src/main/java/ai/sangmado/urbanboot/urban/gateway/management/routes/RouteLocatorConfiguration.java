package ai.sangmado.urbanboot.urban.gateway.management.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/urban/district/**")
                        .uri("lb://urban-district-management-app/")
                        .id("城市区划管理服务"))
                .route(p -> p.path("/urban/traffic/**")
                        .uri("lb://urban-traffic-management-app/")
                        .id("城市交通管理服务"))
                .build();
    }
}
