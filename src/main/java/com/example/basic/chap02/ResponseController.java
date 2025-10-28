package com.example.basic.chap02;

import com.example.basic.chap01.command.ReqVO;
import java.util.Date;
import org.springframework.core.codec.StringDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/chap02")
public class ResponseController {
    @GetMapping("/ex01")
    //return "chap02/ex01";
    public void ex01() {
        //return  "chap02/ex01";
    }

    @GetMapping("/ex02")
    public void ex02(Model model) {
        model.addAttribute("msg","Hello World");
        model.addAttribute("date",new Date());
        model.addAttribute("name","홍길동");
        //return "chap02/ex02";
    }

    @GetMapping("/ex03")
    public ModelAndView ex03() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("chap02/ex03"); //뷰의 정보 지정
        mav.addObject("msg","Hello World");
        mav.addObject("date",new Date());
        mav.addObject("name","홍길동");
        return mav;
    }

    @GetMapping("/ex04")
    public String ex04(@ModelAttribute("id") String id) {
        // id를 받아서, 다음 화면에 id이름으로 데이터를 전달
        return "chap02/ex04";
    }

    @PostMapping("/ex05")
    public String ex05(@ModelAttribute("info") ReqVO vo){
        //화면에서 넘어온 값은 vo에 맵핑하고
        //info라는 이름으로 다른 화면으로 전달
        return "chap02/ex04";
    }

    @GetMapping("login")
    public void login(){
    }

    @PostMapping("loginForm")
    public String loginForm(ReqVO vo, RedirectAttributes ra){
        if (vo.getId().equals(vo.getPw())) {
            return "chap02/login_ok";
        }
        //실패 시에는 메세지 전달gkfugoeh - 리다이렉트 시에는 데이터를 못 보냄
        //model.addAttribute("msg","로그인 실패");
        //근데!!!!!!!!!!!!!!!
        //스프링에서는 리다이렉트 시에 1회성 데이터를 보내는 방법을 제공한다.
        //휘발성 데이터 부여
        ra.addFlashAttribute("msg", "로그인 실패");
        return "redirect:/chap02/login";
    }
}
