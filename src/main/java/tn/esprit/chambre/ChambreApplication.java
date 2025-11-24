package tn.esprit.chambre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChambreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChambreApplication.class, args);
    }

}
