class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int l=0;
        int r=m;
        while(l<=r){
            int px=l+(r-l)/2;
            int py=(m+n+1)/2-px;
            //left side
            int x1=px==0?Integer.MIN_VALUE:nums1[px-1];
            int x2=py==0?Integer.MIN_VALUE:nums2[py-1];
            //right half
            int x3=px==m?Integer.MAX_VALUE:nums1[px];
            int x4=py==n?Integer.MAX_VALUE:nums2[py];
            

            if(x1<=x4 && x2<=x3){
                if((m+n)%2==1){
                    return Math.max(x1, x2);
                }
                return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
            }

            if(x1>x4){
                r=px-1;
            }
            else{
                l=px+1;
            }

        }
        return -1;
    }
}