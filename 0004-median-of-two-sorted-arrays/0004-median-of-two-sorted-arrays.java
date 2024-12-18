class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ind1=0;
        int ind2=0;
        int elem1=0;
        int elem2=0;
        int i=0;
        int j=0;
        int cnt=0;
        ind2=(nums1.length+nums2.length)/2;
        ind1=ind2-1;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                if(cnt==ind1){
                    elem1=nums1[i];
                }
                if(cnt==ind2){
                    elem2=nums1[i];
                }
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1){
                    elem1=nums2[j];
                }
                if(cnt==ind2){
                    elem2=nums2[j];
                }
                cnt++;
                j++;
            }
        }
        while(i<nums1.length){
            if(cnt==ind1){
                elem1=nums1[i];
            }
            if(cnt==ind2){
                elem2=nums1[i];
            }
            cnt++;
            i++;
        }
        while(j<nums2.length){
            if(cnt==ind1){
                elem1=nums2[j];
            }
            if(cnt==ind2){
                elem2=nums2[j];
            }
            cnt++;
            j++;
        }
        if((nums1.length+nums2.length)%2==1){
            return (double)elem2;
        }
        return (double)(elem1+elem2)/2;

    }
}