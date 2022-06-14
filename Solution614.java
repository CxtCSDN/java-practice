package daily.text.month6.day14;

public class Solution614 {
    public static boolean checkRecord(String s) {
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                if (absents >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lates++;
                if (lates >= 3) {
                    return false;
                }
            } else {
                lates = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "PPALLP";
        boolean ret = Solution614.checkRecord(s);
        System.out.println(ret);
    }
}
