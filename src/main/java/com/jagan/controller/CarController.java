package com.jagan.controller;

import com.jagan.Vehicle.Car;
import com.jagan.Vehicle.CarFactory;
import com.jagan.config.AppConfig;
import com.jagan.exception.GlobalExceptionHandler;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;


@Controller("/v1")
@Validated
public class CarController {

    @Inject
    CarFactory carFactory;

    @Inject
    AppConfig appConfig;

    @Inject
    AppConfig.Others others;

    @Get(uri = "/cars", produces = MediaType.TEXT_PLAIN)
    public String getCarInformation(@QueryValue @NotBlank(message = "No type specified")  String type) {
        Car car = carFactory.getCar(type);
        return car.name() + " Price: " + car.price() + " Colors : " +car.color().toString()
                + " Tyres :" + appConfig.getTyre() + " Made In " + appConfig.getMadeIn()
                + " Sedan : " + others.getSedan();
    }



}
