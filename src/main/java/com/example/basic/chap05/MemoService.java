package com.example.basic.chap05;

import java.util.List;

public interface MemoService {
    List<MemoVO> list(); // 메모 조회
    void memoRegist(MemoVO memoVO); // 메모 등록
}
