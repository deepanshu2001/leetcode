class Solution {
    public void helper(char []s,int start,int end){
       if(start>=end){
         return;
       }
       char temp=s[start];
       s[start]=s[end];
       s[end]=temp;
       start++;
       end--;
       helper(s,start,end);
    }
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
}