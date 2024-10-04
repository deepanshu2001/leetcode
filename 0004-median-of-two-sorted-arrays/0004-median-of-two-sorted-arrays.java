class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        int ind=0;
        for(int i=0;i<nums1.length;i++){
            arr[ind]=nums1[i];
            ind++;
        }
        for(int j=0;j<nums2.length;j++){
            arr[ind]=nums2[j];
            ind++;
        }
        Arrays.sort(arr);
        if(arr.length%2==1){
            int r=arr.length/2;
            return (double)arr[r];
        }
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            s++;
            e--;
        }
        return (double)(arr[s]+arr[e])/2;
    }
}