package com.example.basic.quiz.VO;

public class TermsVO {
    private String phoneNumber;
    private boolean agreement;

    public TermsVO() {}

    public TermsVO(String phoneNumber, boolean agreement) {
        this.phoneNumber = phoneNumber;
        this.agreement = agreement;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
}
