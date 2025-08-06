package spring;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication(scanBasePackages = "spring")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
