package com.example.basic.chap05.jdbc;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    //추상메서드 선언
    String getTime();
}
