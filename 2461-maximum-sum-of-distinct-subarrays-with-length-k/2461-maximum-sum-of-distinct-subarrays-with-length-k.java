class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        long sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        while(j<nums.length){
            sum+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k && map.size()==k){
                ans=Math.max(ans,sum);
            }
            if(j-i+1>k){
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
                if(map.size()==k){
                    ans=Math.max(ans,sum);
                }
            }
            j++;
        }
        return ans;
    }
}