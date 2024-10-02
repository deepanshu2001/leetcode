class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[]=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m+n && nums1[i]!=0 && j<n){
            if(nums1[i]<=nums2[j]){
                arr[k]=nums1[i];
                   i++;
                   k++;
            }
            else{
                arr[k]=nums2[j];
                j++;
                k++;
            }
            
        }
        if(i<m+n){
          while(j<n){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        }
        
        while(i<m+n && k<m+n){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        for(int ind=0;ind<m+n;ind++){
            nums1[ind]=arr[ind];
        }
    }
}