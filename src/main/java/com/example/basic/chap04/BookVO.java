package com.example.basic.chap04;

public class BookVO {
    //데이터베이스 컬럼명과 일치되는 멤버변수를 선언
    private long id;
    private String title;
    private String author;

    public BookVO() {}
    public BookVO(long id, String title,String author) {
        this.author = author;
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
