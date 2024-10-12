class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int freq[]=new int[max-min+1];
        for(int num:nums){
            freq[num-min]++;
        }
        int remain=k;
        for(int i=freq.length-1;i>=0;i--){
            remain=remain-freq[i];
            if(remain<=0){
                return i+min;
            }
        }
        return -1;
    }
}