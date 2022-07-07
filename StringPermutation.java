package algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        List<String>list = permutation("abc");
        System.out.println(list);
    }
    public static ArrayList<String>permutation(String str){
        ArrayList<String>res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        process(chars,0,res);
        return res;
    }
    public static void process(char[] chars,int i,ArrayList<String>res){
        if(i == chars.length){
            res.add(String.valueOf(chars));
        }
        boolean[] visit = new boolean[26];
        for(int j = i; j < chars.length; j++){
            if(!visit[chars[j]-'a']){
                visit[chars[j]-'a'] = true;
                swap(chars,i,j);
                process(chars,i+1,res);
                swap(chars,i,j);
            }
        }
    }
    public static void swap(char[]str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}


