class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=max;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>max){
                max=m.getValue();
                ans=m.getKey();
            }
        }
        if(nums.length==1){
            return nums[0];
        }
        return ans;
    }
}