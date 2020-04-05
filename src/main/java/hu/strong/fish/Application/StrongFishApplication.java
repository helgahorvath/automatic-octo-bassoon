package hu.strong.fish.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"hu.strong.fish.*"})
@EntityScan(basePackages = {"hu.strong.fish.*"})
@ComponentScan(basePackages = {"hu.strong.fish.*"})
public class StrongFishApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrongFishApplication.class, args);
    }


}
