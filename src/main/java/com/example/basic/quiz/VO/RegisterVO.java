package com.example.basic.quiz.VO;

public class RegisterVO {
    private String id;
    private String pw;
    private String email;
    private boolean agree;

    public RegisterVO() {}

    public RegisterVO(String id, String pw, String email, boolean agree) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.agree = agree;
    }

    @Override
    public String toString() {
        return "RegisterVO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", agree=" + agree +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
}
