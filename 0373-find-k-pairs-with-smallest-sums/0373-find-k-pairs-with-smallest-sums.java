class Solution {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Pair<Integer,Integer>> set=new HashSet<>();
        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        while(k-->0 && !pq.isEmpty()){
            int []arr=pq.remove();
            List<Integer> temp=new ArrayList<>();
            int i=arr[1];
            int j=arr[2];
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            ans.add(new ArrayList<>(temp));
            if(i+1<nums1.length && !set.contains(new Pair<Integer,Integer>(i+1,j))){
                pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                set.add(new Pair<Integer,Integer>(i+1,j));
            }
            if(j+1<nums2.length && !set.contains(new Pair<Integer,Integer>(i,j+1))){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                set.add(new Pair<Integer,Integer>(i,j+1));
            }

        }
        return ans;
    }
}