class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]+diff) && map.containsKey(nums[i]+2*diff)){
                ans++;
            }
        }
        return ans;
    }
}