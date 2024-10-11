class Solution {
   
    public int minimumSwaps(int[] nums) {
        int cnt=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int min_index=Integer.MAX_VALUE;
        int max_index=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==min){
               min_index=Math.min(min_index,i);
            }
            if(nums[i]==max){
                max_index=Math.max(i,max_index);
            }
        }
        if(min_index>max_index){
            return (min_index-0)+(nums.length-1-max_index)-1;
        }
        return (min_index-0)+(nums.length-1-max_index);
    }
}