class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            if(height[i]<=height[j]){
                max=Math.max(max,(j-i)*height[i]);
                i++;
            }
            else{
                max=Math.max(max,(j-i)*height[j]);
                j--;
            }
        }
        
        return max;
    }
}