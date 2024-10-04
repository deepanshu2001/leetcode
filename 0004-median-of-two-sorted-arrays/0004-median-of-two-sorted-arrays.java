class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=nums1[i];
        }
        int ind=nums1.length;
        for(int i=0;i<nums2.length;i++){
            arr[ind++]=nums2[i];
        }
        Arrays.sort(arr);
        double s=arr[0];
        double e=arr[arr.length-1];
        return s+(e-s)/2;
    }
}