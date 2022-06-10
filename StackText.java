package MyStackText;

import ExpetionText.StackException;

public class StackText {
    public static void main(String[] args) {
        MyStack stack = new MyStack(6);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        while(!stack.empty()){
            try {
                Object top = stack.pop();
                System.out.println(top);
            }catch(StackException e){
                e.getMessage();
            }
        }
        try {
            Object top = stack.pop();
            System.out.println("TextOutput");
        }catch (StackException e){
            String s = e.getMessage();
            System.out.println(s);
        }finally {
            System.out.println("感谢使用");
        }
    }

}
