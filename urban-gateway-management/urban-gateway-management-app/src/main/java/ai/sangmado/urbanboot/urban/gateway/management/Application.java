package ai.sangmado.urbanboot.urban.gateway.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan("ai.sangmado.urbanboot")
public class Application {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
