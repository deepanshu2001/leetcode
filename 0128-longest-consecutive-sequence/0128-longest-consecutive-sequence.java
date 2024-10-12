class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int arr[]=new int[set.size()];
        int ind=0;
        for(int num:set){
          arr[ind]=num;
          ind++;
        }

        Arrays.sort(arr);
        if(nums.length<2){
            return nums.length;
        }
        int ans=0;
        int cnt=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1){
                cnt++;
                ans=Math.max(ans,cnt);
            }
            else{
                ans=Math.max(ans,cnt);
                cnt=1;
            }

        }
        return ans;
    }
}