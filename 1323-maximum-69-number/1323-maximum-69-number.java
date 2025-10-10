class Solution {
    public int maximum69Number (int num) {
        String s=String.valueOf(num);
        int ans=num;
        for(int i=0;i<s.length();i++){
            String first=s.substring(0,i);
            char ch=s.charAt(i);
            ch=ch=='6'?'9':'6';
            String second=s.substring(i+1);
            String result="";
            result+=first;
            result+=ch;
            result+=second;
            int val=Integer.parseInt(result);  
            ans=Math.max(ans,val);          
        }
        return ans;
    }
}