package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan("fun.goodgoodstudy.bestpractice")
public class Application {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
