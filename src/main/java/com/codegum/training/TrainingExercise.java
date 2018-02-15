package com.codegum.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by juliusneria on 18/10/2017.
 */
@SpringBootApplication
public class TrainingExercise {
    private static final Logger log = LoggerFactory.getLogger(TrainingExercise.class);

    public static void main(String[] args) {
        SpringApplication.run(TrainingExercise.class);
    }
}
