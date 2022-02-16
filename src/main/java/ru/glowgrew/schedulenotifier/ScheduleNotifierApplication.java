package ru.glowgrew.schedulenotifier;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Log4j2
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ScheduleNotifierApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleNotifierApplication.class, args);
    }

}
