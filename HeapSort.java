package Day6_13_Sorting;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = {7,3,9,1,4,2,8};
        heap_sort(arr,arr.length);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void heap_sort(int[] arr, int n){
        int gap = n / 2;
        while(gap != 0){
            for(int i = 0; i < arr.length-gap; i++){
                int end = i;
                int tmp = arr[end+gap];
                while(end >= 0){
                    if(tmp < arr[end]){
                        arr[end+gap] =arr[end];
                        end -= gap;
                    }
                    else break;
                }
                arr[end+gap] = tmp;
            }
            gap /= 2;
        }
    }
}
