class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s=1;
        int max=Integer.MIN_VALUE;
        
        int ans=0;
        int e=1000000;
        while(s<=e){
            int mid=s+(e-s)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=Math.ceil(nums[i]*1.0/mid*1.0);
            }
            if(sum<=threshold){
               ans=mid;
               e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}