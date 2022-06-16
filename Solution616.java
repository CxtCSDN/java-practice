package daily.text.month6.day16;

public class Solution616 {
    public static void main(String[] args) {

    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i <= k){
                ans += Math.min(tickets[i],tickets[k]);
            }else{
                ans += Math.min(tickets[i],tickets[k-1]);
            }
        }
        return ans;
    }
}
