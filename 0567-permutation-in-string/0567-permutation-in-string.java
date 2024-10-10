class Solution {
    public String sort(String s){
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        String t=new String(ch);
        return t;
    }
    public boolean checkInclusion(String s1, String s2) {
        char []ch1=new char[s1.length()];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            ch1[i]=ch;
        }
        Arrays.sort(ch1);
        s1="";
        for(int i=0;i<ch1.length;i++){
            s1+=ch1[i];
        }
        int len=s1.length();
        for(int i=0;i<=s2.length()-s1.length();i++){
            if(s1.equals(sort(s2.substring(i,i+len)))){
                return true;
            }
        }
        return false;
    }
}