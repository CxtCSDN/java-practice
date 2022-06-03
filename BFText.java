package Day6_13_Text_String;

public class BFText {
    public static void main(String[] args){
        String str = "abcdabcabcdb";
        String sub = "cdb";
        int ret = BFText(str,sub,0);
        System.out.println(ret);
    }
    public static int BFText(String str, String sub, int pos){
        if(str == null || sub == null) return -1;
        int strLen = str.length();
        int subLen = sub.length();
        if(strLen == 0 || subLen == 0) return -1;
        if(pos < 0 || pos >= strLen) return -1;

        int i = pos;
        int j = 0;
        while(i < strLen && j < subLen){
            if(str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if(j >= subLen) {
            return i - j;
        }
        return -1;
    }
}
