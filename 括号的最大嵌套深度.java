import java.util.*;

class Solution {

    public int maxDepth(String s) {
        int ans = 0, cnt = 0;
        for (char c: s.toCharArray())
            ans = Math.max(ans, cnt += c == '(' ? 1 : c == ')' ? -1 : 0);
        return ans;
    }
};