class Solution {
    public boolean isValid(String s,int start,int end,int k,int cntmap[]){
        int cnt_f=0;
        int cnt_no=0;
        for(int freq:cntmap){
            if(freq>0){
                cnt_f++;
            }
            if(freq>=k){
                cnt_no++;
            }
        }
        return cnt_f==cnt_no;

    }
    public int longestSubstring(String s, int k) {
        int cntmap[]=new int[26];
        int ans=0;
        for(int start=0;start<s.length();start++){
            Arrays.fill(cntmap,0);
            for(int end=start;end<s.length();end++){
                cntmap[s.charAt(end)-'a']++;
                if(isValid(s,start,end,k,cntmap)){
                   ans=Math.max(ans,end-start+1);
                }
            }
        }
        return ans;
    }
}