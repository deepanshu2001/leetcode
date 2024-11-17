class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int cnt_arr[]=new int[max+1];
        for(int i=0;i<nums.length;i++){
            cnt_arr[nums[i]]++;
        }
        int cnt=nums.length/3;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<cnt_arr.length;i++){
            if(cnt_arr[i]>cnt){
               ans.add(i);
            }
        }
        return ans;
    }
}