class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int cnt1=0;
        int cnt2=0;
        int elem1=Integer.MIN_VALUE;
        int elem2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!=elem2){
                elem1=nums[i];
                cnt1++;

            }
            else if(cnt2==0 && nums[i]!=elem1){
                cnt2++;
                elem2=nums[i];
            }
            else if(nums[i]==elem1){
                cnt1++;

            }
            else if(nums[i]==elem2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        int c1=0;
        int c2=0;
        int cnt=nums.length/3;
        for(int num:nums){
            if(num==elem1){
                c1++;
            }
            else if(num==elem2){
                c2++;
            }
        }
        if(c1>cnt){
            ans.add(elem1);
        }
        if(c2>cnt){
            ans.add(elem2);
        }
        return ans;
    }
}