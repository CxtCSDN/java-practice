public class Prime {
    public static void main(String[] args) {
        int n = 0;
        //boolean isPrime=true;//用来标识每次计算的数是否是素数
        for (int x = 2; x <= 100; x++) {
            boolean isPrime=true;//用来标识每次计算的数是否是素数
            int m = x / 2;
            for (int i = 2; i <= m; i++) {
                if (x % i == 0) {
                    isPrime = false;//
                    break;
                }
            }
            if(isPrime){
                System.out.print(x+"\t");
                n++;
            }
            if(n != 0 && n % 5 == 0 && isPrime){
                System.out.println();
            }
        }
    }
}