package com.example.basic.chap04;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    List<BookVO> list(); //도서조회
    void bookRegist(BookVO bookVO); //도서등록
    void bookDelete(long id); //도서삭제
}
