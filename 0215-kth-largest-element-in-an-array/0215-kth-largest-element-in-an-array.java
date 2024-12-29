class Solution {
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int partition(int L,int R,int nums[]){
       int i=L+1;
       int p=nums[L];
       int j=R;
       while(i<=j){
        if(nums[i]<p && nums[j]>p){
            swap(i,j,nums);
            i++;
            j--;
        }
        if(nums[i]>=p){
            i++;
        }
        if(nums[j]<=p){
            j--;
        }
       }
       swap(L,j,nums);
       return j;
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length-1;
        int L=0;
        int R=n;
        int pivot=0;
        while(true){
           pivot=partition(L,R,nums);
           if(pivot==k-1){
                break;   
           }
           else if(pivot>k-1){
              R=pivot-1;
           }
           else{
            L=pivot+1;
           }
        }
        return nums[pivot];
    }
}