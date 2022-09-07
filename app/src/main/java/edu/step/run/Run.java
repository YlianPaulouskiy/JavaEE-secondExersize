package edu.step.run;

import edu.step.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.step.*")
public class Run {

    public static void main(String[] args) {

//        SpringApplication.run(Run.class, args);
        new View().view();
    }

}


