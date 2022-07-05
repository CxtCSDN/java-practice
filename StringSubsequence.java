package algorithm.recursion;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.List;

public class StringSubsequence {
    public static void process(char[]str,int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str,i+1);
        char tmp = str[i];
        str[i] = 0;
        process(str,i+1);
        str[i] = tmp;
    }
    public static void process1(char[]str, int i, List<Character>res){
        if(i == str.length){
            System.out.println(res);
            return;
        }
        List<Character>inList = copyList(res);
        inList.add(str[i]);
        process1(str,i+1,inList);
        List<Character>outList = copyList(res);
        process1(str,i+1,outList);
    }
    public static List<Character> copyList(List<Character>res){
        List<Character>newList = new ArrayList<>();
        for(Character character : res){
            newList.add(character);
        }
        return newList;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<Character>res = new ArrayList<>();
        process1(str.toCharArray(),0,res);
        process(str.toCharArray(),0);
    }
}
