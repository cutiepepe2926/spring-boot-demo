package com.example.basic.chap04;

public class BookVO {
    private String bookName;
    private long id;

    public BookVO() {}

    public BookVO(String bookName, long id) {
        this.bookName = bookName;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
