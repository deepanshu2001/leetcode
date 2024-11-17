class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        int cnt=n/3;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>cnt){
                set.add(m.getKey());
            }
        }
        List<Integer> ans=new ArrayList<>(set);
        return ans;
    }
}