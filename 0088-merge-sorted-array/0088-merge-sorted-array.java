class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind=0;
        for(int i=m;i<nums1.length;i++){
            nums1[i]=nums2[ind];
            ind++;
        }
        int max=0;
        int min=0;
        for(int i=0;i<nums1.length;i++){
            max=Math.max(nums1[i],max);
            min=Math.min(nums1[i],min);
        }
        int arr[]=new int[max-min+1];
        for(int i=0;i<nums1.length;i++){
            arr[nums1[i]-min]++;
        }
        ind=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                while(arr[i]>0){
                   nums1[ind]=i+min;
                   arr[i]--;
                   ind++;
                }
            }
        }
        
    }
}