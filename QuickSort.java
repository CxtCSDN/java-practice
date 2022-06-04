package Day6_04_Sorting;

import java.util.Stack;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[] {4,3,9,1,0,7,2,5,8};
//        quick_sort(arr,0,arr.length-1);
        quick_sort_nonR(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    //优化一：三数取中
    public static int get_mid_of(int[] arr, int left, int right){
        int mid = (left+right) >> 1;
        if(arr[left] > arr[right]){
            if(arr[mid] > arr[left]){
                return left;
            }else if(arr[mid] > arr[right]){
                return mid;
            }else{
                return right;
            }
        }else{
            if(arr[mid] > arr[right]){
                return right;
            }else if(arr[mid] > arr[left]){
                return mid;
            }else{
                return left;
            }
        }
    }
    //优化二：小区间优化
    public static void quick_sort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = quick_sort_1(arr,left,right);
        quick_sort(arr,left,mid-1);
        quick_sort(arr,mid+1,right);
    }
    public static void swap(int[] arr, int n1, int n2){
        int tmp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = tmp;
    }
    public static int quick_sort_1(int[] arr, int left, int right){
        int index = get_mid_of(arr,left,right);
        swap(arr,index,left);
        int pivot = left;
        int keyI = arr[left];
        while(left < right){
            while(left < right && arr[right] > keyI){
                right--;
            }
            if(left < right){
                arr[left++] = arr[right];
                pivot = right;
            }
            while(left < right && arr[left] < keyI){
                left++;
            }
            if(left < right){
                arr[right--] = arr[left];
                pivot = left;
            }
        }
        pivot = left;
        arr[pivot] = keyI;
        return pivot;
    }
    public static int quick_sort_2(int[] arr, int left, int right){
        int index = get_mid_of(arr,left,right);
        swap(arr,index,left);
        int keyI = left;
        while(left < right){
            while(left < right && arr[right] >= arr[keyI]){
                right--;
            }
            while(left < right && arr[left] <= arr[keyI]){
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,keyI,left);
        return left;
    }
    public static int quick_sort_3(int[] arr, int left ,int right){
        int index = get_mid_of(arr,left,right);
        swap(arr,index,left);
        int keyI = left;
        int fast = left + 1, slow = left;
        while(fast < arr.length){
            if(arr[fast] < arr[keyI] && ++slow != fast){
                swap(arr,fast,slow);
            }
            fast++;
        }
        swap(arr,keyI,slow);
        return slow;
    }
    //快速排序非递归实现
    public static void quick_sort_nonR(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr.length-1);
        stack.push(0);
        while(!stack.empty()){
            int left = stack.pop();
            int right = stack.pop();
            int mid = quick_sort_1(arr,left,right);
            if(mid + 1 < right){
                stack.push(right);
                stack.push(mid+1);
            }
            if(mid-1>left){
                stack.push(mid-1);
                stack.push(left);
            }
        }
    }
}
