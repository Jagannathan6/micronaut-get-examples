package com.jagan.Vehicle;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CarFactory {

    @Inject
    Car2 car2;

    @Inject
    Car1 car1;

    public Car getCar(String type) {
        if ("car1".equalsIgnoreCase(type)) {
            return car1;
        } else {
            return car2;
        }
    }
}
