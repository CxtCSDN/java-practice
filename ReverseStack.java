package algorithm.recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        reverse(stack);
        System.out.println(stack);
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }
        int last = bottom(stack);
        reverse(stack);
        stack.push(last);
    }
    public static int bottom(Stack<Integer> stack){
        int ret = stack.pop();
        if(stack.empty()){
            return ret;
        }
        else{
            int last = bottom(stack);
            stack.push(ret);
            return last;
        }
    }
}
