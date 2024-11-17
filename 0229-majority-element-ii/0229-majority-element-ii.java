class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int cnt_arr[]=new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            cnt_arr[nums[i]-min]++;
        }
        int cnt=nums.length/3;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<cnt_arr.length;i++){
            if(cnt_arr[i]>cnt){
               ans.add(i+min);
            }
        }
        return ans;
    }
}