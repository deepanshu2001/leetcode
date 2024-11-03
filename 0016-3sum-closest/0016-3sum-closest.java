class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int dif=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int s=i+1;
            int e=nums.length-1;
            while(s<e){
                int sum=nums[i]+nums[s]+nums[e];
                if(Math.abs(target-sum)<dif){
                    dif=target-sum;
                }
                if(sum<target){
                    s++;
                }
                else{
                    e--;
                }
            }
            
        }
        return target-dif;
    }
}