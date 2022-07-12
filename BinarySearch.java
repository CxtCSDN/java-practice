package algorithm.recursion;

import java.util.Scanner;

public class BinarySearch {
    public static int numSize,count,left,right,mid;
    public static void binarySearch(){
        Scanner scanner = new Scanner(System.in);
        numSize =  scanner.nextInt();
        count = scanner.nextInt();
        int[] num = new int[numSize];
        for(int i = 0; i < numSize; i++){
            num[i] = scanner.nextInt();
        }
        left = 0;
        right = numSize;
        mid = (left + right) >> 1;
        int target = 0;
        for (int i = 0; i < count; i++) {
            target = scanner.nextInt();
            left = 0;
            right = numSize;
            while (left < right) {
                mid = (left + right) >> 1;
                if (num[mid] < target) {
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            if(num[left] == target){
                System.out.println(left+1);
            }else{
                System.out.println(-1);
            }
        }
    }
}
