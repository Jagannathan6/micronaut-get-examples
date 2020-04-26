package com.jagan.controller;

import com.jagan.Vehicle.Car;
import com.jagan.response.ApiResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@Validated
public class HelloWorldController {

     private Car car;

    @Inject
    public HelloWorldController(@Named(value = "maruti") Car car) {
        this.car = car;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello World!";
    }

    @Get("/hello/{name}")
    public String sayHelloName(String name) {
        return "hello " + name;
    }

    @Get("/{greeting}/{name}")
    public String sayGreetingName(String greeting,  String name) {
        return greeting + " " + name;
    }

    @Get("/wishes/{type}")
    public String sayWishes(String type, @QueryValue Optional<String> name) {
        if ("morning".equalsIgnoreCase(type)) {
            if (name.isPresent()) {
                return "Good Morning " +  name.get();
            } else {
                return "Good Morning";
            }
        } else {

            if (name.isPresent()) {
                return "Good Day " + name.get();
            } else {
                return "Good Day";
            }

        }

    }

    @Get("/bday")
    public String sayWishes(@QueryValue @NotBlank(message = "Name cannot be Empty") String name) {
        return "Happy Birthday " + name;
    }

    @Get("/cars")
    public String getCarInformation() {
        return car.name() + " Price: " + car.price() + " Colors : " +car.color().toString();
    }

}
