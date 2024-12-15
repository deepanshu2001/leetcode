class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<int[]> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int arr[]=new int[2];
            arr[0]=m.getKey();
            arr[1]=m.getValue();
            list.add(arr);
        }
        Collections.sort(list,(a,b)->a[1]-b[1]);
        int ans[]=new int[k];
        int ind=0;
        for(int i=list.size()-1;i>=list.size()-k;i--){
            ans[ind]=list.get(i)[0];
            ind++;
        }
        return ans;
    }
}