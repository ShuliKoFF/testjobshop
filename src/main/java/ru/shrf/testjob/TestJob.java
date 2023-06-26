package ru.shrf.testjob;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RequiredArgsConstructor
@EnableSwagger2
public class TestJob {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestJob.class, args);
    }


}
