package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controllers"})
@EnableJpaRepositories("repositories")
@EntityScan("entities")
public class App {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(App.class, args);
        checkBeansPresence(
                "app", "ownersController", "ownersService", "ownersRepository");
    }

    private static void checkBeansPresence(String... beans) {
        for (String beanName : beans) {
            System.out.println("Is " + beanName + " in ApplicationContext: " +
                    applicationContext.containsBean(beanName));
        }
    }
}
