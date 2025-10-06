class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxF=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            maxF=Math.max(maxF,map.get(num));
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int val=m.getValue();
            if(val==maxF){
                ans+=val;
            }
        }
        return ans;
    }
}