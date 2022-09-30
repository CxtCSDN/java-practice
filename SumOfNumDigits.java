import java.util.Scanner;

public class SumOfNumDigits {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a number between 0 and 1000: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num < 0 || num > 1000){
            throw new Exception("输入数据超出预定范围");
        }
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        System.out.println("The sum of the digits is "+sum);
    }
}
