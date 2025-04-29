class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int distinct=set.size();
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int j=0;
        int i=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==distinct){
                ans+=nums.length-j;
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        
        }
        return ans;
    }
}