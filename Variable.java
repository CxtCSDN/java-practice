public class Variable {
    public static void main(String[] args) {
        int a=10;
        char ch1 = 'a';
        a=ch1+a;
        System.out.printf("ch1=%c\n",a);
        char ch2 = 100;
//        char ch3 = 65536;
        float f1 = 10.0f;
        double d1 = 100.0d;
        boolean flag = true;
//        f1 = d1;
//        System.out.println("f1="+f1);
        System.out.println("a="+a);
        System.out.println("ch1="+ch1);
        System.out.println("ch2="+ch2);
//        System.out.println("ch3="+ch3);
        System.out.println("d1="+d1);
        Variable v=new Variable();
        System.out.println("v="+v.toString());
    }
}

