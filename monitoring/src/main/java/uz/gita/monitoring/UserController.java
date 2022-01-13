package uz.gita.monitoring;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@Slf4j
@RestController
@RequestMapping("api/v1")
public class UserController {

    @GetMapping("/")
    public ResponseEntity<String> userRequest() {
        log.info("Request api/v1/");
        if (new Random().nextBoolean()) throw new RuntimeException("Some exception");

        return ResponseEntity.ok("OK");
    }

    private final Counter visitFemaleCounter;
    private final Counter visitMaleCounter;

    public UserController(MeterRegistry registry) {
        visitFemaleCounter = Counter.builder("visit_female_counter")
                .description("Number of visits to the site")
                .register(registry);

        visitMaleCounter = Counter.builder("visit_male_counter")
                .description("Number of visits to the site")
                .register(registry);
    }

    @GetMapping("/female")
    public String female() {
        visitFemaleCounter.increment();
        return "Hello World!";
    }

    @GetMapping("/male")
    public String male() {
        visitMaleCounter.increment();
        return "Hello World!";
    }
}
