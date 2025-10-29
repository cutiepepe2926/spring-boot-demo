package com.example.basic.chap04;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl /*implements BookService*/ {
    private List<BookVO> list = new ArrayList<>();
    private long newId = 1;


    public List<BookVO> list() {
        return list;
    }


    public boolean bookRegister(BookVO bookvo) {
        return true;
    }
}
