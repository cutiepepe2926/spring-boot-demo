package com.example.basic.chap05;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemoMapper {
    List<MemoVO> list() ;
    void memoRegist(MemoVO memoVO);
}
