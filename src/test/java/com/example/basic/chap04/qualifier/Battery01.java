package com.example.basic.chap04.qualifier;

import org.springframework.stereotype.Component;

@Component("Battery01")
public class Battery01 implements IBattery {

    private String batteryName = "battery01";

    @Override
    public String getInfo() {
        return batteryName;
    }
}
