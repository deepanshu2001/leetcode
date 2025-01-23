class Solution {
    public String compressedString(String word) {
        StringBuilder comp=new StringBuilder();
        for(int i=0;i<word.length();i++){
           char ch=word.charAt(i);
           int j=i;
           int cnt=0;
           while(j<word.length() && cnt<9 && ch==word.charAt(j)){
            cnt++;
            j++;
           }
           i=j-1;
           comp.append(cnt);
           comp.append(ch);
        }
        return comp.toString();
    }
}