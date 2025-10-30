package com.example.basic.chap05;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chap05")
public class MemoController {

    private final MemoService memoService;

    public MemoController(
            @Qualifier("memoService")
            MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memoList")
    public String memoList(Model model) {
        List<MemoVO> list = memoService.list();
        model.addAttribute("list",list);
        return "chap05/memoList";
    }

    @GetMapping("memoWrite")
    public String memeWrite() {
        return "chap05/memoWrite";
    }

    @PostMapping("/memoRegist")
    public String memoRegist(MemoVO memoVO) {
        memoService.memoRegist(memoVO);
        return "redirect:/chap05/memoList";
    }
}
