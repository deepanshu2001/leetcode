class Solution {
    public long minimumSteps(String s) {
        int whiteBalls=0;
        long cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                cnt+=i-whiteBalls;
                whiteBalls++;
            }
        }

        return cnt;
    }
}