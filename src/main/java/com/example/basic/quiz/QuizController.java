package com.example.basic.quiz;

import com.example.basic.quiz.VO.TermsVO;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.basic.quiz.VO.RegisterVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @GetMapping("/quiz01")
    public void quiz01() {}

    @PostMapping("join")
    public String join(@ModelAttribute("info") RegisterVO vo, RedirectAttributes ra) {
        if (!vo.getId().isEmpty() && !vo.getPw().isEmpty() && !vo.getEmail().isEmpty() && vo.isAgree()==true) {
            return "quiz/quiz01_ok";
        }
        if (!vo.isAgree()) {
            ra.addFlashAttribute("msg","정보이용에 동의해주세요.");
            return "redirect:/quiz/quiz01";
        }

        ra.addFlashAttribute("msg","회원가입 실패");
        return "redirect:/quiz/quiz01";
    }

    @GetMapping("/terms")
    public ModelAndView terms() {
        ModelAndView mv = new ModelAndView("quiz/terms");
        String termsContent = "제1조 (목적)\n" +
                "이 약관은 서비스 이용에 관한 사항을 규정함을 목적으로 합니다.\n\n" +
                "제2조 (정의)\n" +
                "이 약관에서 사용하는 용어의 정의는 다음과 같습니다.\n" +
                "1. '서비스'란 회사가 제공하는 모든 서비스를 의미합니다.\n" +
                "2. '이용자'란 서비스를 이용하는 자를 의미합니다.\n\n" +
                "제3조 (약관의 효력)\n" +
                "이 약관은 이용자가 동의함으로써 효력을 발생합니다.";
        mv.addObject("termsContent",termsContent);

        return mv;
    }

    @PostMapping("termsAgree")
    public String termsAgree(@ModelAttribute("info") TermsVO vo, RedirectAttributes ra) {
        if (vo.isAgreement() && !vo.getPhoneNumber().isEmpty()) {
            return "quiz/terms_ok";
        }
        if (!vo.isAgreement()) {
            ra.addFlashAttribute("msg","약관에 동의해주세요.");
            return "redirect:/quiz/terms";
        }
        if (vo.getPhoneNumber().isEmpty()) {
            ra.addFlashAttribute("msg","전화번호를 입력해주세요.");
            return "redirect:/quiz/terms";
        }
        return "redirect:/quiz/terms";
    }

}
