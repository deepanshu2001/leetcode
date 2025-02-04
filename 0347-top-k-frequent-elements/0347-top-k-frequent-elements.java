class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int elem=m.getKey();
            int freq=m.getValue();
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(elem);
        }
        int ans[]=new int[k];
        int ind=0;
        for(int i=nums.length;i>=0;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size() && ind<k;j++){
                    ans[ind]=bucket[i].get(j);
                    ind++;
                    if(ind==k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}