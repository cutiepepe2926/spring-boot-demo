package com.example.basic.chap03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chap03")
public class ViewController {

    @GetMapping("/ex01")
    public void ex01(){}

    @GetMapping("/ex02")
    public void ex02(Model model){
        //1개의 vo = 1회원 정보
        List<SimpleVO> list = new ArrayList<>();

        for (int i = 1; i <=10; i++) {
            SimpleVO vo = new SimpleVO();
            vo.setName("홍길동"+i);
            vo.setAge(20+i);
            vo.setRegdate(LocalDateTime.now());
            list.add(vo);
        }
        model.addAttribute("list",list);
    }

    @GetMapping("/ex03")
    public void ex03(Model model){
        //1개의 vo = 1회원 정보
        List<SimpleVO> list = new ArrayList<>();

        for (int i = 1; i <=10; i++) {
            SimpleVO vo = new SimpleVO();
            vo.setName("홍길동"+i);
            vo.setAge(20+i);
            vo.setRegdate(LocalDateTime.now());
            list.add(vo);
        }
        model.addAttribute("list",list);
    }

    @GetMapping("/ex03_ok")
    public void ex03_ok(@RequestParam("name") String name){
        System.out.println(name);
    }

    @GetMapping("/ex04")
    public void ex04(Model model){
        model.addAttribute("name","홍길동");
        model.addAttribute("arr",new int[] {1,2,3,4,5});
        model.addAttribute("regdate",LocalDate.now());
    }

    @GetMapping("/ex05")
    public void ex05(){}
}
