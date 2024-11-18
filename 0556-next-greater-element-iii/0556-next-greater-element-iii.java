


class Solution {
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int i,int j,int nums[]){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length-2;
        //find the break point;
        for(int i=n;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,nums.length-1, nums);
            return;
        }
        //find the next greater;
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(i,ind,nums);
                break;
            }
        }
        //reverse the res;
        reverse(ind+1,nums.length-1, nums);
    }
    public int nextGreaterElement(int n) {
       int cnt=0;
        int N=n;
        while(N>0){
            N=N/10;
            cnt++;
        }
        int arr[]=new int[cnt];
        N=n;
        int ind=0;
        while(N>0){
            int rem=N%10;
            arr[ind]=rem;
            ind++;
            N=N/10;
        }
        nextPermutation(arr);
        int num=0;
        for(int i=arr.length-1;i>=0;i--){
          num=num*10+arr[i];
        }
        if(num<=n||num>Integer.MAX_VALUE){
            return -1;
        }
        return num;
    }
}