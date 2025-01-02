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
        
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(bs(nums2,nums1[i])){
                if(!set.contains(nums1[i])){
                    list.add(nums1[i]);
                    set.add(nums1[i]);
                }
            }
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
       return ans;
    }
}