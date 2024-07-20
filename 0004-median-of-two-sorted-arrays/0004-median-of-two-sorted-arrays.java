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
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            if(s==e){
                return (double)(arr[s]);
            }
            s++;
            e--;
        }
        double a=arr[s]*1.0;
        double b=arr[e]*1.0;
        return (a+b)/2*1.0;
    }
}