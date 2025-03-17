class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int val=m.getValue();
            if(val%2==0){
                cnt+=val/2;
            }
        }
        return cnt==nums.length/2;
    }
}