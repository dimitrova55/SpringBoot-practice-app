package com.example.spring_demo.rest;

import com.example.spring_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    // field injection - not recommended, no need for constructors or setters
    // @Autowired
    // private Coach coach;

    private Coach coach;
    private Coach anotherCoach;

    // constructor injection: required dependency
    @Autowired
    public CoachController(@Qualifier("baseballCoach") Coach coach,
                           @Qualifier("baseballCoach") Coach anotherCoach){
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    // setter injection: optional dependency
    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach coach,
                         @Qualifier("baseballCoach") Coach anotherCoach){
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: coach == anotherCoach? " + (coach == anotherCoach);
    }
}
