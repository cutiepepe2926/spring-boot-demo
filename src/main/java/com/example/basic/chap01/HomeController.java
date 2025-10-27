package com.example.basic.chap01;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("Hello World");
        return "hello";
    }
}
