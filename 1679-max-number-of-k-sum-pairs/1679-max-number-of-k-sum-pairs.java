class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int sum=k-nums[i];
            if(map.containsKey(sum) && map.get(sum)>0){
                cnt++;
                map.put(sum,map.get(sum)-1);
            }
            else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return cnt;
    }
}