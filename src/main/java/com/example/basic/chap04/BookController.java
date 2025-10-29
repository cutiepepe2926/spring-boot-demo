package com.example.basic.chap04;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chap04")
public class BookController {

    @GetMapping("/list")
    public void list() {}

    @GetMapping("/new")
    public void newBook() {}

    @PostMapping("/bookRegister")
    public void bookRegister(BookVO bookVO) {

    }

}
