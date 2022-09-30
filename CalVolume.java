import java.util.Scanner;

public class CalVolume {
    public static void main(String[] args) {
        System.out.print("Enter the radius and length of a cylinder:");
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double length = scanner.nextDouble();
        double area = Math.pow(radius,2)*Math.PI;
        System.out.println("The area is " + area);
        System.out.println("The volume is " + area * length);
    }
}
