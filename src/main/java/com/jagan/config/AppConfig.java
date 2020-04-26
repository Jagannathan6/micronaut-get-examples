package com.jagan.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.bind.annotation.Bindable;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("vehicle.car")
public interface AppConfig {

    public String getTyre();

    @Bindable(defaultValue = "India")
    String getMadeIn();

    @ConfigurationProperties("others")
    interface Others {

        String getSedan();
    }

}
