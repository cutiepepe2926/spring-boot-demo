package com.example.basic.chap04.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainClass {

	/*
	TODO
	1. IBattery를 구현체 Battery01 클래스를 만듭니다.
	2. MainClass에서 멤버변수 주입 시키고 Test메서드에서 확인하세요.
	
	*/
    @Autowired
    @Qualifier("Battery01")
    private IBattery Battery02;

//    @Autowired
//    Battery01 bt01;
//
//    @Autowired
//    Battery02 bt02;


    @Test
    public void text() {
        System.out.println(Battery02.getInfo());
        //System.out.println(bt02.getInfo());
    }
}
