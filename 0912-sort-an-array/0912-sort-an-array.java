class Solution {
    public int [] merge(int arr1[],int arr2[]){
        int arr[]=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
           if(arr1[i]<=arr2[j]){
              arr[k++]=arr1[i];
              i++;
           }
           else{
            arr[k++]=arr2[j];
            j++;
           }
        }
        while(i<arr1.length){
            arr[k++]=arr1[i];
            i++;
        }
        while(j<arr2.length){
            arr[k++]=arr2[j];
            j++;
        }
        return arr;
    }
    public int[] sortArray(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        int mid=nums.length/2;
        int []left=sortArray(Arrays.copyOfRange(nums,0,mid));
        int []right=sortArray(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }
}