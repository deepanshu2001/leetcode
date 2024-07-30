class Solution {
    public int minimumDeletions(String s) {
       int cnt=0;
       int result=0;
       for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         if(ch=='b'){
            cnt++;
         }
         else if(ch=='a'){
            if(cnt>0){
              result++;
              cnt--;
            }
         }
       }
       return result; 
    }
}