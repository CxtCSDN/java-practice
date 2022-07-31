

import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] cnt = new int[1001];
        for (int e : arr1) ++cnt[e];
        for (int e : arr2)
            while  (0 < cnt[e]--) ans.add(e);
        for (int e = 0; e < 1001; ++e)
            while  (0 < cnt[e]--) ans.add(e);
        int[] arr = new int[arr1.length];
        int index = 0;
        for(int i : ans){
            arr[index++] = i;
        }
        return arr;
    }
}