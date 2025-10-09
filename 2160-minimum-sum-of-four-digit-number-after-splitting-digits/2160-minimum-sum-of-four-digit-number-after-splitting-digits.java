class Solution {
    public int minimumSum(int num) {
        
        int nums[]=new int[4];
        int i=0;
        while(num>0){
           int rem=num%10;
           nums[i]=rem;
           i++;
           num=num/10;
        }
        Arrays.sort(nums);
        int ans=(nums[0]*10)+nums[2];
        ans+=(nums[1]*10)+nums[3];
        return ans;


    }
}