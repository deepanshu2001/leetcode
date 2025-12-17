class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        Set<Integer> set=new HashSet<>();
        int cnt_arr[]=new int[n];
        int i=0;
        int j=0;
        int ans=0;
        while(j<n){
            cnt_arr[fruits[j]]++;
            set.add(fruits[j]);
            if(set.size()>2){
                cnt_arr[fruits[i]]--;
                if(cnt_arr[i]==0){
                    set.remove(fruits[i]);
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}