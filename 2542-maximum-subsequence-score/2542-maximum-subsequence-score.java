class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        //creating a element of pair
        int arr[][]=new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            arr[i][0]=nums2[i];
            arr[i][1]=nums1[i];
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long curr_sum=0;
        long ans=0;
        for(int i=0;i<k-1;i++){
           curr_sum+=arr[i][1];
           pq.add(arr[i][1]);
        }
        for(int i=k-1;i<nums1.length;i++){
            curr_sum+=arr[i][1];
            pq.add(arr[i][1]);
            ans=Math.max(ans,arr[i][0]*curr_sum);
            curr_sum-=pq.remove();
        }
        return ans;
    }
}