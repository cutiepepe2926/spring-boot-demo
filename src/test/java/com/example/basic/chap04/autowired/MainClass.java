package com.example.basic.chap04.autowired;

import com.example.basic.chap04.di.AppConfig;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.Printer;

@SpringBootTest
public class MainClass {
//    AnnotationConfigApplicationContext ctx = new
//            AnnotationConfigApplicationContext();
    @Autowired
    ApplicationContext ctx;

    @Test
    public void test(){

        //ctx.scan("com.example.basic.chap04.autowired");

        String arr[] = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(arr));
    }

    @Autowired
    printer printer;

    @Test
    public void test03(){
        System.out.println("자동주입완료 : "+printer.getDocument().data);
    }
}
