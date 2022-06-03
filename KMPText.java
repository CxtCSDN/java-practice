package Day6_13_Text_String;

//KMP算法
public class KMPText {
    public static void main(String[] args){
        String str = "abcdabcabcdb";
        String sub = "cdb";
        int ret = KMP(str,sub,0);
        System.out.println(ret);
    }
    public static int KMP(String str, String sub, int pos){
        if(str == null || sub == null) return -1;
        int strLen = str.length();
        int subLen = sub.length();
        if(strLen == 0 || subLen == 0) return -1;
        if(pos < 0 || pos >= strLen) return -1;

        int[] next = new int[subLen];
        //获取next数组
        get_next(sub, next);

        int i = pos;//遍历主串
        int j = 0;//遍历子串
        while(i < strLen && j < subLen){
            if(j == -1 || str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j >= subLen){
            return i-j;
        }
        return -1;

    }
    //获取next数组
    public static void get_next(String sub, int[] next){
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int k = 0;
        //遍历子串，得到next数组
        while(i < sub.length()){
            if(k == -1 || sub.charAt(i-1) == sub.charAt(k)){
                next[i] = k+1;//公式推导得出
                i++;
                k++;
            }else{
                //若不相等则k进行回退
                k = next[k];
            }
        }
        //next数组的优化->nextVal
        for(int j = 1; j < sub.length(); j++){
            if(sub.charAt(next[j]) == sub.charAt(j)) {
                next[j] = next[next[j]];
            }
        }

    }
}
