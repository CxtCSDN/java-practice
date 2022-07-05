package algorithm.recursion;

public class Hanoi {
    public static void move(char A,char C){
        System.out.println(A + "->" + C);
    }
    public static void hanoi(int n,char A,char B,char C){
        if(n == 1){
            move(A,C);
            return;
        }else{
            hanoi(n-1,A,C,B);
            move(A,C);
            hanoi(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        hanoi(3,'a','b','c');
    }
}
