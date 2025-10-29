package com.example.basic.chap04.qualifier;

import org.springframework.stereotype.Component;

@Component("Battery02")
public class Battery02 implements IBattery {
    private String batteryName = "battery02";

    public String getInfo() {
        return batteryName;
    }
}
