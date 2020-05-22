package ai.sangmado.urbanboot.urban.iptable.management.swagger;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Value("${springfox.documentation.service.title}")
    private String serviceTitle;
    @Value("${springfox.documentation.service.description}")
    private String serviceDescription;

    @Bean
    @SuppressWarnings("Guava")
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfo(
                serviceTitle,
                serviceDescription,
                null,
                null,
                null,
                null,
                null,
                new ArrayList<>(0));
    }
}
