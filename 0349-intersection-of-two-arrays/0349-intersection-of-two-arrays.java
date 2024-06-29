class Solution {
    public boolean bs(int arr[],int target){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>target){
                e=mid-1;
            }
            else if(arr[mid]<target){
                s=mid+1;
            }
            else if(arr[mid]==target){
               return true;
            }
        }
        return false;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int f=Integer.MAX_VALUE;
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
           if(f==nums2[i]){
            continue;
           }
           if(bs(nums1,nums2[i])==true){
              a.add(nums2[i]);
              f=nums2[i];
           }

        }
        int ans[]=new int[a.size()];
        for(int i=0;i<a.size();i++){
            ans[i]=a.get(i);
        }
        return ans;
    }
}