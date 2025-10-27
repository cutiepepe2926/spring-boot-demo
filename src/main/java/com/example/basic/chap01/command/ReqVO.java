package com.example.basic.chap01.command;

//VO(value Object) = 값을 저장하는 용도의 클래스

import java.util.ArrayList;

public class ReqVO {
    //멤버 변수는 은익하고,
    //getter, setter를 생성함.

    // 1. 멤버변수는 생성
    private String id;
    private String pw;
    private String name;
    private ArrayList<String> inter;

    // 2.
    public ReqVO() {
    }
    public ReqVO(String id, String pw, String name, ArrayList<String> inter) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.inter = inter;
    }

    @Override
    public String toString() {
        return "ReqVO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", inter=" + inter +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getInter() {
        return inter;
    }

    public void setInter(ArrayList<String> inter) {
        this.inter = inter;
    }
}

