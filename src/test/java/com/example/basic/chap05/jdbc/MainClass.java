package com.example.basic.chap05.jdbc;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainClass {

    //세션 객체를 얻을 때, sqlSession객체를 사용함
//    @Autowired
//    SqlSession sqlSession;

    @Autowired
    TestMapper tm;

    @Test
    public void test(){
        //TestMapper tm = sqlSession.getMapper(TestMapper.class);
        //System.out.println(sqlSession);
        System.out.println(tm);
        System.out.println(tm.getTime());
    }
}
