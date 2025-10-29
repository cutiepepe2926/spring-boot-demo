package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 여기서 컴포넌트 스캔 시작 (base패키지를 읽음)
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

        SpringApplication.run(SpringBootDemoApplication.class, args);

        //스프링 키면서 하고 싶은 작업이 있으면, 추가

    }

}
