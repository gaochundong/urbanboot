package ai.sangmado.urbanboot.urban.traffic.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * Urban Traffic Management Application
 *
 * @author gaochundong
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("ai.sangmado.urbanboot")
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2WebMvc
public class Application {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
