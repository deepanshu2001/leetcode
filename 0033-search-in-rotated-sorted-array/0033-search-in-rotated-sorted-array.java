class Solution {
    public int BS(int []arr,int target,int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target==arr[mid]){
                return mid;
            }
            else if(arr[mid]>target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }
    public int findpivot(int arr[]){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            //4 cases
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(s<mid && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            else if(arr[s]>=arr[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot=findpivot(nums);
        if(pivot==-1){
            return BS(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        else if(target<nums[0]){
            return BS(nums,target,pivot+1,nums.length-1);
        }
        return BS(nums,target,0,pivot-1);
    }
}