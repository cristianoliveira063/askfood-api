package br.com.askfood;

import br.com.askfood.infraestruture.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class AskfoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskfoodApiApplication.class, args);
    }

}
