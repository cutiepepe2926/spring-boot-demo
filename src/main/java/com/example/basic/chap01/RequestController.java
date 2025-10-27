package com.example.basic.chap01;

import com.example.basic.chap01.command.LoginVO;
import com.example.basic.chap01.command.ReqVO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//com.example.basic 패키지 아래에 있는 이 어노테이션이 붙어있는 파일들을 자동으로 객체로 생성해줌
@Controller
@RequestMapping("/chap01")
public class RequestController {

    // GET, POST 둘 다 허용
    @RequestMapping("/ex01")
    public String req_Ex01() {
        //return "ex01";
        //접두사 : template/
        //접미사 : .html
        System.out.println("리다이렉트 떳냐?");
        return "chap01/ex01";
    }

    @RequestMapping("/quiz01")
    public void req_quiz01() {

    }

    @PostMapping("/login")
    public String login(LoginVO vo) {
        System.out.println(vo.toString());
        if ("abc123".equals(vo.getId())) {
            if ("xxx123".equals(vo.getPw())) {
                System.out.println("로그인 성공");
                return "chap01/quiz01_ok";
            }
        }
        System.out.println("로그인 실패");
        return "chap01/quiz01_no";
    }

    // GET 요청만 허용함.
    //@RequestMapping(value = "/basic01", method = RequestMethod.GET)
    @GetMapping("/basic01")
    public String basic01(){
        System.out.println("basic 01 메서드 동작됨");
        return null;
    }

    //post요청만 허용함
    //@RequestMapping(value = "/basic02", method = RequestMethod.POST)
    @PostMapping("/basic02")
    public String basic02(){
        System.out.println("basic 02 메서드 동작됨");
        return null;
    }
    // 각 요청을 집합으로 묶어서 사용할 수 있음
//    @RequestMapping(value = {"/basic01","/basic02","생략..."})
//    public void basic() {
//        System.out.println("basic01-02요청 처리");
//    }

    // void형의 경우, 들어오는 경로가 나가는 경로와 동일
//    @GetMapping("/ex02")
//    public void ex02(){
//
//    }

    // String형의 경우, 들어오는 경로, 나가는 경로 따로 지정 가능
    // 나가는 경로는 return으로 반환
    @GetMapping("/ex02")
    public String ex02(){
        return "chap01/ex02";
    }
    //
    @GetMapping("/redirect")
    public String redirect(){
        return "chap01/ex01"; // 기본 이동은 forward 형식을 따라감
        //return "redirect:/chap01/ex01";
        // -> 강제로 페이지 보내기라 보내면 컨트롤러가 catch해서 그 경로 대로 날아감
    }

    @GetMapping("/redirectHome")
    public String redirect_home(){
        return "redirect:/";
    }

//    @PostMapping("/param")
//    public String param01(HttpServletRequest request) {
//        String id = request.getParameter("id");
//        String pw = request.getParameter("pw");
//        String name = request.getParameter("name");
//        String[] inter = request.getParameterValues("inter");
//        System.out.println(id+","+pw+","+name+","+ Arrays.toString(inter));
//        return "chap01/ex02_ok";
//    }

    //RequestParam은 반드시 화면에서 데이터를 넘겨야 되는데,
    // 넘기지 않더라도 허용하려면 required 옵션을 사용
    //defaultValue는 값이 넘어오지 않을 때 기본값을 지정.
//    @PostMapping("/param")
//    public String param01(@RequestParam("id") String id,
//                          @RequestParam("pw") String pw,
//                          @RequestParam("name") String name,
//                          @RequestParam(value = "inter", required = false, defaultValue = "기본값") String[] arr) {
//        System.out.println(id+","+pw+","+name+","+ Arrays.toString(arr));
//        System.out.println(arr[0]);
//        return "chap01/ex02_ok";
//    }
    @PostMapping("/param")
    public String param01(ReqVO vo){
        System.out.println(vo.toString());
        return "chap01/ex02_ok";
    }
}
