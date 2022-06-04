package Day6_04_Text;

import java.util.Scanner;

public class Text {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("您输入的是：" + input);
        FlyAble f1 = new Cat();
        FlyAble f2 = new Pig();
        f1.fly();
        f2.fly();
        Animal a1 = new Cat();
        Animal a2 = new Pig();
        if(a1 instanceof FlyAble){
            FlyAble f3 = (FlyAble)a1;
            f3.fly();
        }
    }
}

class Animal{
    void move(){
        System.out.println("动物在移动");
    }
}

interface FlyAble{
    void fly();
}

class Cat extends Animal implements FlyAble{
    public void fly(){
        System.out.println("这是一只飞猫");
    }
}
class Snake extends Animal{
    void move(){
        System.out.println("蛇在移动");
    }
}
class Pig extends Animal implements FlyAble{
    public void fly(){
        System.out.println("这是一只飞猪");
    }
}