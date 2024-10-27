class Solution {
    public String sort(String s){
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public boolean checkInclusion(String s1, String s2) {
        String s=sort(s1);
        int len=s.length();
        for(int i=0;i<=s2.length()-len;i++){
            String new_string=sort(s2.substring(i,i+len));
            if(s.equals(new_string)){
                return true;
            }
        }
        return false;
    }
}