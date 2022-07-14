import java.util.*;

class Solution {
    public String replaceSpaces(String S, int length) {
        char[] str = S.toCharArray();
        int count = 0;
        for(int i = 0; i < length; i++){
            if(str[i] == ' '){
                count++;
            }
        }
        int index = 0;
        char[] tmp = new char[length+2*count];
        for(int i = 0; i < length; i++){
            if(str[i] != ' '){
                tmp[index++] = str[i];
            }else{
                tmp[index++] = '%';
                tmp[index++] = '2';
                tmp[index++] = '0';
            }
        }
        return String.valueOf(tmp);
    }
}