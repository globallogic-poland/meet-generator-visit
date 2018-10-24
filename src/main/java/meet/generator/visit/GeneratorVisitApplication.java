package meet.generator.visit;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.dto.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@SpringBootApplication
public class GeneratorVisitApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorVisitApplication.class, args);
    }

    @Override
    public void run(String... args) {
        WebClient.builder().build().get().uri("http://localhost:31100/patients")
                .retrieve().bodyToFlux(Patient.class)
                .subscribe(p -> log.info("{}", p));

    }
}
