package com.example.basic.chap06;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.javassist.Loader.Simple;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //완전히 다른 방식으로 동작함!!!
@RequestMapping("/chap06")
public class RestBasicController {

    //@ResponseBody // 요청 온 곳으로 응답함, 자바의 Object를 JSON 형시그로 자동 변환
    // (controller + responsebody)인데 귀찮으면 그냥 RestController하면 됨.
    @GetMapping("/basic")
    public String basic() {
        return "하이하이!";
    }

    // 데이터를 응답하는 바법
    // 1. Object
    @GetMapping("/getObject")
    public SimpleVO getObject() {

        SimpleVO simpleVO = new SimpleVO(1,"홍","길동", LocalDateTime.now());

        return simpleVO;
    }

    // 2. map
    @GetMapping("/getMap")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","홍길동");
        map.put("age",22);
        map.put("hobby", new String[] {"밥","먹", "기"});
        map.put("regdate", LocalDateTime.now());
        return map;
    }

    // 3. List
    @GetMapping("/getList")
    public List<SimpleVO> getList() {
        List<SimpleVO> list = new ArrayList<>();
        list.add(new SimpleVO(1,"홍","길동",LocalDateTime.now()));
        return list;
    }

    // 데이터를 받는 방법
    // Get 주소를 통해서 받음 -> 유형 2가지 존재 쿼리스트링(? 방식) or 쿼리파라미터 (url주소방식)
    // Post 바디에 데이터를 담아서 보냄 -> Form 형식 or JSON 형식

    // localhost:8181/chap06/getData?id=홍길동&age=20
    @GetMapping("/getData")
    public SimpleVO getData(@RequestParam("id") String id,
                            @RequestParam("age") int age) {
        System.out.println(id + "," + age);
        return new SimpleVO(1,"홍","길동",LocalDateTime.now());
    }


    //localhost:8181/chap06/getData2?num=1&first=이&last=순신
    @GetMapping("/getData2")
    public String getData2(SimpleVO simpleVO) {
        System.out.println(simpleVO.toString());
        //return simpleVO.toString();
        return "success";
    }

    //localhost:8181/chap06/getData3/이순신/22
    @CrossOrigin(origins = "http://127.0.0.1:3000") // 경로 말고 Origin만! //이 주소에서 오는 요청은 허용한다.
    @GetMapping("/getData3/{name}/{age}")
    public String getData3(@PathVariable("name") String name,
                           @PathVariable("age") int age) {
        System.out.println(name+","+age);
        return "success";
    }


    // post 방식
    // client에서 form형식으로 데이터를 sending
    //localhost:8181/chap06/getForm
    @PostMapping("/getForm")
    public String getForm(SimpleVO simpleVO) {
        System.out.println(simpleVO.toString());
        return "success";
    }

    // client에서 json형식으로 데이터를 보내기
    // JSON의 경우, @RequestBody를 사용하면 된다.
//    @PostMapping("/getJSON")
//    public String getJSON(@RequestBody SimpleVO simpleVO) {
//        System.out.println(simpleVO.toString());
//        return "success";
//    }
    //SimpleVO(num=1, first=홍, last=길동, regdate=null)

    // Map 형식으로 데이터 보내기 -> 불가피할 때는 이거 쓰고 보통은 JSON 형식으로 처리하는게 기본이다.
    @CrossOrigin(origins = "http://127.0.0.1:3000") // 경로 말고 Origin만! //이 주소에서 오는 요청은 허용한다.
    @PostMapping("/getJSON")
    public String getJSON(@RequestBody Map<String, Object> map) {
        System.out.println(map.toString());
        return "success";
    }
    //{num=1, first=홍, last=길동}




    // consumer - 반드시 데이터를 이 타입으로 보내!
    // producer - 내가 이 타입으로 줄게!!

//    @PostMapping(value = "/getResult", consumes = "text/plain", produces = "text/plain")
//    public String getResult(@RequestBody String str) {
//        System.out.println(str);
//        return "<h3>success</h3>";
//    }

    //ResponseEntity - response할 때, 응답에 대한 내용을 상세하게 작성할 수 있다
    @CrossOrigin("http://127.0.0.1:3000/COURSE-1/") //이 주소에서 오는 요청은 허용한다.
    @PostMapping(value = "/getResult", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> getResult(@RequestBody String str) {
        System.out.println(str);

        HttpHeaders headers = new HttpHeaders();
        headers.add("jwt" ,"JSON WEB TOKEN");
        headers.add("Access-Control-Allow-Origin","true");
        headers.add("hohoho", "babo");
        headers.add("Authorization", "Bearer Token");

        ResponseEntity<String> result = new ResponseEntity<String>("success",headers, HttpStatus.OK);

        return result;
    }

    @CrossOrigin(origins = "http://127.0.0.1:3000") // 경로 말고 Origin만! //이 주소에서 오는 요청은 허용한다.
    @GetMapping("/api/v1/getData/{num}/{name}")
    public SimpleVO getData_api(@PathVariable("num") int num,
                           @PathVariable("name") String name) {
        System.out.println(num+","+name);
        SimpleVO simpleVO = new SimpleVO(num,"홍",name, LocalDateTime.now());

        return simpleVO;
    }

    @CrossOrigin(origins = "http://127.0.0.1:3000") // 경로 말고 Origin만! //이 주소에서 오는 요청은 허용한다.
    @PostMapping("/api/v1/getInfo")
    public ResponseEntity<List<SimpleVO>> getInfo_api(@RequestBody Map<String, Object> map) {
        HttpHeaders headers = new HttpHeaders();
        System.out.println(map.toString());
        headers.add("jwt" ,"JSON WEB TOKEN");
        headers.add("Authorization", "Bearer Token");

        SimpleVO simpleVO = new SimpleVO(12,"이","순신", LocalDateTime.now());
        SimpleVO simpleVO2 = new SimpleVO(14,"이","순신", LocalDateTime.now());
        List<SimpleVO> list = new ArrayList<>();
        list.add(simpleVO);
        list.add(simpleVO2);

        ResponseEntity<List<SimpleVO>> result = new ResponseEntity<>(list,headers, HttpStatus.OK);

        return result;
    }






}
