class Solution {
    public int helper(int nums[],int mid,int k){
      int cnt=1;
      int sum=0;
      for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                cnt++;
                sum=nums[i];
            }
       }
       return cnt;
    }
    public int splitArray(int[] nums, int k) {
      
       int s=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        s=Math.max(nums[i],s);
       }
       int e=0;
       int ans=0;
       for(int i=0;i<nums.length;i++){
          e+=nums[i];
       }
       while(s<=e){
        int mid=s+(e-s)/2;
        int cnt=helper(nums,mid,k);
        if(cnt>k){
            s=mid+1;
        }
        else{
            
            e=mid-1;
        }
       }
       return s;
    }
}