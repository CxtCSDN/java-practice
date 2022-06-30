package javase.datastruct.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

//逆波兰计算器
public class Calculator2 {
    public static ArrayList<String> infix_to_suffix(String infixExpression){
        //(3+2)*5-6/2*(4-3)
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int index = 0;//遍历索引
        String num = "";
        while(true){
            //如果是一个数字则入栈
            if(Calculator.is_num(infixExpression.charAt(index))){
                //存放多位数
                num += infixExpression.charAt(index);
                //如果是最后一位字符，则数字直接入栈即可
                if(index == infixExpression.length()-1){
                    stack1.push(num);
                }else{
                    //否则等到碰到下一个字符为运算符再将存放的数字入栈
                    if(!Calculator.is_num(infixExpression.charAt(index+1))){
                        stack1.push(num);
                        num = "";
                    }
                }
                //否则即不是数字
            }else{
                //当前为运算符的情况
                while(Calculator.is_operator(infixExpression.charAt(index))){
                    //②栈为空或者②栈栈顶为(的情况则直接入栈
                    if(stack2.empty() || stack2.peek().equals("(")){
                        stack2.push(String.valueOf(infixExpression.charAt(index)));
                        break;
                        //否则即当前运算符的优先级高于②栈栈顶运算符的优先级则也直接入栈
                    }else if(Calculator.pripority(stack2.peek().charAt(0)) < Calculator.pripority(infixExpression.charAt(index))){
                        stack2.push(String.valueOf(infixExpression.charAt(index)));
                        break;
                        //否则将②栈栈顶的运算符push到①栈并pop掉重新进行上述逻辑进行判断
                    }else{
                        stack1.push(stack2.pop());
                    }
                }
                //当前为括号
                if(Calculator.is_parentheses(infixExpression.charAt(index))){
                    //为左括号则直接入栈
                    if(infixExpression.charAt(index) == '('){
                        stack2.push(String.valueOf(infixExpression.charAt(index)));
                    }else{
                        //为右括号的情况则一直出②栈直至左括号，并抛弃这对括号
                        while(!stack2.peek().equals("(")){
                            stack1.push(stack2.pop());
                        }
                        stack2.pop();
                    }
                }
            }
            index++;
            if(index >= infixExpression.length()){
                break;
            }
        }
        //将②栈剩余的运算符入到①栈
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        //拼接②栈中的字符串作为返回值
        ArrayList<String> res = new ArrayList<>();
        while(!stack1.empty()){
            res.add(stack1.pop());
        }
        //拼接后的逆序即为后缀表达式
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) {
//        String infixExpression = "(3+2)*5-6/2*(4-3)";//22
        String infixExpression = "1+((2+3)*4)-5";//123+4*+5- //16
        ArrayList<String>suffix = infix_to_suffix(infixExpression);
        Stack<Integer>num = new Stack<>();
        for(String val : suffix){
            if(Calculator.is_operator(val.charAt(0))){
                int num1 = num.pop();
                int num2 = num.pop();
                switch (val.charAt(0)){
                    case '+':
                        num.push(num1+num2);
                        break;
                    case '-':
                        num.push(num2-num1);
                        break;
                    case '*':
                        num.push(num1*num2);
                        break;
                    case '/':
                        num.push(num2/num1);
                        break;
                }
            }else{
                num.push(Integer.valueOf(val));
            }
        }
        System.out.println(num.peek());
    }
}
