class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;
        while(left != right){
            int bottom = right-left;
            int h = Math.min(height[left],height[right]);
            int area = bottom*h;
            if(max < area) max = area;
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}