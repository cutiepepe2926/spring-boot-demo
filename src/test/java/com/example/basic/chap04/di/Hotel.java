package com.example.basic.chap04.di;

public class Hotel {
    private Chef chef;


    // 생성자를 통한 chef 주입
    public Hotel(Chef chef) {
        this.chef = chef;
    }

    //setter, getter
    //getter 메서드를 통해서 chef 주입
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    public Chef getChef() {
        return chef;
    }
}
