class Solution {
    public void merge(int nums[],int s,int m,int e){
        int arr[]=new int[e-s+1];
        int i=s;
        int j=m+1;
        int k=0;
        while(i<=m && j<=e){
            if(nums[i]<=nums[j]){
                arr[k++]=nums[i];
                i++;
            }
            else{
                arr[k++]=nums[j];
                j++;
            }
        }
        while(i<=m){
            arr[k++]=nums[i];
            i++;
        }
        while(j<=e){
            arr[k++]=nums[j];
            j++;
        }
        for(int ind=0;ind<arr.length;ind++){
            nums[s+ind]=arr[ind];
        }
    }
    public void sort(int nums[],int s,int e){
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        sort(nums,s,mid);
        sort(nums,mid+1,e);
        merge(nums,s,mid,e);
    }
    public int[] sortArray(int[] nums) {
       sort(nums,0,nums.length-1);
       return nums;
    }
}