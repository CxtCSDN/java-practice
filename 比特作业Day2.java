import java.util.*;

public class Solution {
    public static int FirstNotRepeatingChar(String str) {
        if(str.length() == 0){
            return -1;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        HashSet<Character> hashSet = new HashSet<>();
        char[]arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(!hashSet.contains(arr[i])){
                hashSet.add(arr[i]);
                hashMap.put(arr[i],i);
            }else{
                hashMap.remove(arr[i]);
            }
        }
        if(hashMap.isEmpty()){
            return -1;
        }
        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entries : hashMap.entrySet()){
            if(entries.getValue() < minIndex){
                minIndex = entries.getValue();
            }
        }
        return minIndex;
    }
    public static boolean isUnique(String astr) {
        for(int i = 0; i < astr.length(); i++){
            char val = astr.charAt(0);
            astr = astr.substring(1);
            if(astr.contains(String.valueOf(val))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(isUnique(str));
    }
}