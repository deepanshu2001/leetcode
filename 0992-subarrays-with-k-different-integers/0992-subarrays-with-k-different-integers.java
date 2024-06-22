class Solution {
    public int func(int nums[],int k){
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
       
        int i=0;
        int j=0;
        if(k<0){
            return 0;
        }
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.size()>k){
               while(map.size()>k){
                 map.put(nums[i],map.get(nums[i])-1);
                 if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                 }
                 i++;
               }
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }
}