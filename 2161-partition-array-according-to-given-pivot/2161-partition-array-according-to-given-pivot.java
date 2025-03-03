class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int i=0;
        int j=0;
        int k=0;
        int ind=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]<pivot){
                ans[ind]=nums[i];
                ind++;
                
            }
            i++;
        }
        while(j<n){
            if(nums[j]==pivot){
                ans[ind]=nums[j];
                ind++;
                
            }
            j++;
        }
         while(k<n){
            if(nums[k]>pivot){
                ans[ind]=nums[k];
            
                ind++;
            }
            k++;
        }

        return ans;
    }
}