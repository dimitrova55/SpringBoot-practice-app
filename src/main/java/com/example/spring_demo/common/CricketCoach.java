package com.example.spring_demo.common;

import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
// @Primary
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast boiling for 15 minutes.";
    }
}
