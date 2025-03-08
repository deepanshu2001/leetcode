class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cnt_w=0;
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(j<blocks.length()){
            char ch=blocks.charAt(j);
            if(ch=='W'){
                cnt_w++;
            }
            if(j-i+1==k){
                ans=Math.min(ans,cnt_w);
            }
            while(j-i+1>k){
                if(blocks.charAt(i)=='W'){
                    cnt_w--;
                }
                i++;
                if(j-i+1==k){
                    ans=Math.min(ans,cnt_w);
                }
            }
            j++;
        }
        return ans;
    }
}