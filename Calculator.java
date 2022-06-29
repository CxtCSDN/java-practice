package javase.datastruct.stack;

import java.util.Stack;

public class Calculator {
    public static int pripority(char operator){
        if(operator == '+' || operator == '-'){
            return 0;
        }else if(operator == '*' || operator == '/'){
            return 1;
        }else{
            return -1;
        }
    }
    public static boolean is_num(int num){
        return num >= '0' && num <= '9';
    }

    //中缀表达式
    public static void main(String[] args) {
        String pression = "70+2*6-4";//计算表达式
        Stack<Integer> numStack = new Stack<>();//数字栈
        Stack<Character> operatorStack = new Stack<>();//运算符栈
        int index = 0;//遍历标记
        int num1 = 0, num2 = 0;
        char operator = ' ';
        String num = "";
        while(true){
            //如果是数字则入数字栈
            if(is_num(pression.charAt(index))){
                num += pression.charAt(index);
                if(index == pression.length()-1){
                    numStack.push(Integer.parseInt(num));
                }else if(!is_num(pression.charAt(index+1))){
                    numStack.push(Integer.parseInt(num));
                    num = "";
                }

            }else{
                    //否则即为运算符
                    //如果运算符栈为空则直接入栈
                    if(operatorStack.empty()){
                        operatorStack.push(pression.charAt(index));
                    }
                    //不为空则判断当前遍历到的运算符优先级
                    else{
                        //若优先级大于运算符栈顶的运算符的优先级则入栈
                        if(pripority(pression.charAt(index)) > pripority(operatorStack.peek())){
                            operatorStack.push(pression.charAt(index));
                        }else{
                            //否则取出数字栈两个元素以及运算符栈栈顶元素进行运算
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            operator = operatorStack.pop();
                            switch (operator){
                                case '+':
                                    numStack.push(num1+num2);
                                    break;
                                case '-':
                                    numStack.push(num2-num1);
                                    break;
                                case '*':
                                    numStack.push(num1*num2);
                                    break;
                                case '/':
                                    numStack.push(num2/num1);
                                    break;
                            }
                            //运算完毕后记得将判断优先级的那个未入栈的运算符入栈
                            operatorStack.push(pression.charAt(index));
                        }
                    }
                }
            index++;
            if(index >= pression.length())
                break;
        }
        while(!operatorStack.empty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            switch (operator){
                case '+':
                    numStack.push(num1+num2);
                    break;
                case '-':
                    numStack.push(num2-num1);
                    break;
                case '*':
                    numStack.push(num1*num2);
                    break;
                case '/':
                    numStack.push(num2/num1);
                    break;
            }
        }
        System.out.println(numStack.size());
        System.out.println(numStack.peek());
    }
}
