class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            sum+=nums[i];
            pq.add(sum);
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                pq.add(sum);
            }
        }
        int ans=0;
        int l=1;
        while(l!=left){
            pq.remove();
            l++;
        }
        while(l<=right){
            ans+=pq.remove();
            l++;
        }
        return (int)ans%10000000;
    }
}