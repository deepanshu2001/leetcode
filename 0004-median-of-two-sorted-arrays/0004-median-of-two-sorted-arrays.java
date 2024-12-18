class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        int ind=0;
        for(int i=0;i<nums1.length;i++){
            arr[ind]=nums1[i];
            ind++;
        }
        for(int i=0;i<nums2.length;i++){
            arr[ind]=nums2[i];
            ind++;
        }
        Arrays.sort(arr);
        if(arr.length%2==1){
            return (double)arr[arr.length/2];
        }
        int l1=arr[arr.length/2-1];
        int l2=arr[arr.length/2];
        return (l1+l2)*1.0/2;

    }
}