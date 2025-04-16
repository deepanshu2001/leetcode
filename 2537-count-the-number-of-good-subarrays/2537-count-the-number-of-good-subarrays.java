class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        long cnt = 0;  
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        
        for (int j = 0; j < nums.length; j++) {
            int freq = map.getOrDefault(nums[j], 0);
            cnt += freq;
            map.put(nums[j], freq + 1);
            
            while (cnt >= k) {
                ans += nums.length - j;
                int freqI = map.get(nums[i]);
                cnt -= freqI - 1; 
                map.put(nums[i], freqI - 1);
                i++;
            }
        }
        
        return ans;
    }
}
