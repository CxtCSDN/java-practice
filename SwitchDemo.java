class SwitchDemo{
    public static void main(String args[]) {
        int a = 1,b = 1,count = 0;
        while ( a <= 1000 ){
            a = 2 * a;
            b = b + 1;
            count++;
        }
        System.out.println( b );
        System.out.println(count);
    }
}