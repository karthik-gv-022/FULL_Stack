package com.example.fitness_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // 👈 tells Spring to use application-test.properties
class FitnessBackendApplicationTests {

    @Test
    void contextLoads() {
    }
}
