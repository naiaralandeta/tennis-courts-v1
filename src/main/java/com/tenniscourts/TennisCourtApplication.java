package com.tenniscourts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.tenniscourts.guests.*;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class TennisCourtApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TennisCourtApplication.class, args);
    }

}