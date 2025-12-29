class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            sum+=nums[j];
            while(map.size()<j-i+1){
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            ans=Math.max(ans,sum);
            j++;
        }
        return ans;
    }
}