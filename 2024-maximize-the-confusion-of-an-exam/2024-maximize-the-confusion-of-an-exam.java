class Solution {
    public int sw1(String answerKey,int k){
        int i=0;
        int ans=0;
        int j=0;
        int cnt=0;
        while(j<answerKey.length()){
            char ch=answerKey.charAt(j);
            if(ch=='F'){
                cnt++;
            }
            while(cnt>k){
                char p=answerKey.charAt(i);
                if(p=='F'){
                    cnt--;
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
            
        }
        return ans;
    }
    public int sw2(String answerKey,int k){
         int i=0;
        int ans=0;
        int j=0;
        int cnt=0;
        while(j<answerKey.length()){
            char ch=answerKey.charAt(j);
            if(ch=='T'){
                cnt++;
            }
            while(cnt>k){
                char p=answerKey.charAt(i);
                if(p=='T'){
                    cnt--;
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int m1=sw1(answerKey,k);//flip F;
        int m2=sw2(answerKey,k); //flip T;
        return Math.max(m1,m2);
    }
}