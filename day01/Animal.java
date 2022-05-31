package com.cxt.jave.day01;

public class Animal {
    private final int age;
    public Animal() {
        age = 0;
    }

    public void move(){
        System.out.println("动物在跑");
    }
    public void eat(){
        System.out.println("动物在吃东西");
    }
}
