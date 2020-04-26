package com.jagan.Vehicle;

import javax.inject.Singleton;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Singleton
public class Car1 implements Car{
    @Override
    public String name() {
        return "Maruti";
    }

    @Override
    public long price() {
        return 100000;
    }

    @Override
    public List<String> color() {
        return Arrays.asList("Blue");
    }
}
