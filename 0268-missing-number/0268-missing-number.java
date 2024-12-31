class Solution {
    public int missingNumber(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            list.add(i);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            list.remove(m.getValue());
        }
        return list.get(0);
    }
}