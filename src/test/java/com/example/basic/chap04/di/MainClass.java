package com.example.basic.chap04.di;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class MainClass {
    @Test
    public void test01() {
//        //자바 객체로 직접 생성을 한다면
//        //
//        Chef chef = new Chef("쉐프");
//        Hotel hotel = new Hotel(chef); //생성자 주입
//        
//        Chef chef2 = new Chef("쉐프2");
//        hotel.setChef(chef2); //setter 주입
        //스프링은 위 과정을 IoC 컨테이너 안에서 사람 대신 해주는 것
    }

    // IOC방식으로 확인하기
    // 전역 설정 파일
    ApplicationContext ctx = new
            AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    public void test02() {
        // IOC 컨테이너에 미리 생성된 객체 확인
//        String[] arr = ctx.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(arr));

        //스프링에 미리 생성된 Chef객체를 얻기
//        Chef chef = ctx.getBean(Chef.class);
//        System.out.println("IOC 내부의 bean: " + chef.cook("Pasta") );

        Hotel hotel = ctx.getBean(Hotel.class);
        Chef c = hotel.getChef();
        System.out.println(c.cook("라면!!!"));
    }

}
