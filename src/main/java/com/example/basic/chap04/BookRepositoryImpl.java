package com.example.basic.chap04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {
    /*
    데이터베이스 연결 정보
    디비 드라이버 클래스이름
    유저아이디
    유저패스워드
    디비연결주소
     */

    // JDBC
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Override
    public List<BookVO> list() {

        // SELECT 결과를 담을 list
        List<BookVO> list = new ArrayList<>();

        String sql = "SELECT * FROM BOOK ORDER BY ID DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; //select에서만 필요, 실행 결과를 가져옴.

        try {
            // 1. 드라이버 클래스 준비
            Class.forName(driver);

            // 2. 커넥션 객체 (연결 객체) 준비
            conn = DriverManager.getConnection(url,username,password);

            //연결 체크 -> 문제 시 에러나 null출력됨
            System.out.println(conn);

            // 3. state 객체를 얻음(sql 전달을 위한 객체)
            ps = conn.prepareStatement(sql);

            // 5. 실행 - executeUpdate (실행 성공 여부만 알 수 있는 함수), executeQuery (실행 결과를 받아올 수 있는 함수)
            rs = ps.executeQuery(); //성공 실패 여부를 반환

            while(rs.next()){
                // 1행에 대한 처리 - rs.getSTring, rs.getInt, rs.getDate
                long id = rs.getLong("id"); // id 컬럼
                String title = rs.getString("title"); //title 컬럼
                String author = rs.getString("author"); //author컬럼

                System.out.println(id);
                System.out.println(title);
                System.out.println(author);

                BookVO bookVO = new BookVO(id,title,author);
                list.add(bookVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          try {
              if (ps != null) ps.close(); // 6. ps 반환하기 (얘네는 try 바깥에서 처리해줘야 함)
              if (conn != null) conn.close(); // 7. conn 반환하기 (얘네는 try 바깥에서 처리해줘야 함)
              if (rs != null) rs.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
        }

        return list;
    }

    @Override
    public void bookRegist(BookVO bookVO) {
        // JDBC

        //book_seq.nextval은 다음 책 ID값
        String sql = "INSERT INTO BOOK(ID, TITLE, AUTHOR) VALUES (BOOK_SEQ.NEXTVAL, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            // 1. 드라이버 클래스 준비
            Class.forName(driver);

            // 2. 커넥션 객체 (연결 객체) 준비
            conn = DriverManager.getConnection(url,username,password);

            //연결 체크 -> 문제 시 에러나 null출력됨
            System.out.println(conn);

            // 3. state 객체를 얻음(sql 전달을 위한 객체)
            ps = conn.prepareStatement(sql);

            // 4. ? 값을 채웁니다. (?는 키는 순서대로 1번부터 시작함)
            ps.setString(1, bookVO.getTitle());
            ps.setString(2, bookVO.getAuthor());

            // 5. 실행 - executeUpdate (실행 성공 여부만 알 수 있는 함수), executeQuery (실행 결과를 받아올 수 있는 함수)
            int result = ps.executeUpdate(); //성공 실패 여부를 반환

            if (result == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close(); // 6. ps 반환하기 (얘네는 try 바깥에서 처리해줘야 함)
                if (conn != null) conn.close(); // 7. conn 반환하기 (얘네는 try 바깥에서 처리해줘야 함)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void bookDelete(long id) {

    }


    /*
    //가짜 데이터베이스 ArrayList <--
    private List<BookVO> list = new ArrayList<>();
    private long newId = 1; //book데이터를 관리할 pk


    @Override
    public List<BookVO> list() {
        //데이터베이스 연결해서 처리
        return list;
    }

    @Override
    public void bookRegist(BookVO bookVO) {
        bookVO.setId(newId);
        newId++;
        list.add(bookVO);
        System.out.println(list.toString());
    }

    @Override
    public void bookDelete(long id) {
        System.out.println("넘어온값:" + id);
        //삭제
        for(int i = 0; i < list.size(); i++) {
            BookVO vo = list.get(i);
            if(vo.getId() == id) {
                list.remove(i); //id가 같으면, 인덱스 번째 데이터삭제
                break;
            }
        }
    }
     */



}
