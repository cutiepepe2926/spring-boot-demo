package com.example.basic.chap04.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
//@Repository
//@Controller
@Component
public class printer {
    
    // AutoWired - IOC컨테이너 안에 있는 적합한 빈을 자동으로 주입
    
    // 1. 타입으로 검색 -> 이름으로 검색
    // 1.1 필드, 생성자, 세터에 적용 가능
    
    //@Resource, @Inject -> 동일한 의미인데, 낮은 버전용임(1.8)
    
    //@Autowired
    private document document;

    //@Autowired
    public printer(document document) {
        this.document = document;
    }

    public document getDocument() {
        return document;
    }
    @Autowired
    public void setDocument(document document) {
        this.document = document;
    }
}
