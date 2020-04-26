package com.jagan.Vehicle;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Car2 implements Car{
    @Override
    public String name() {
        return "Ford";
    }

    @Override
    public long price() {
        return 1000000;
    }

    @Override
    public List<String> color() {
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blues");
        return colors;
    }
}
