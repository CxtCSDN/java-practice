package Day6_13_Sorting;

public class SelectSort {
    public static void main(String[] args){
        int[] arr = {7,3,9,1,4,2,8};
        select_sort(arr,arr.length);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    //向一个有序序列中插入一个数，使原序列仍有序
    public static void select_sort(int[] arr, int n){
        for(int i = 0; i < n-1; i++){
            int end = i;
            int tmp = arr[end+1];
            while(end >= 0){
                if(tmp < arr[end]){
                    arr[end+1] = arr[end];
                    end--;
                }
                else
                    break;
            }
            arr[end+1] = tmp;
        }
    }
}
