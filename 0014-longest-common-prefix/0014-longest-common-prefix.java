class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str=strs[0];
        for(int i=1;i<strs.length;i++){
            if(str.indexOf(strs[i])!=-1){
                str=strs[i];
            }
            else{
                String s="";
                String s1=str;
                String s2=strs[i];
                int len=s1.length()<s2.length()?s1.length():s2.length();
                for(int j=0;j<len;j++){
                    if(s1.charAt(j)==s2.charAt(j)){
                        s+=s1.charAt(j);
                    }
                    else{
                        break;
                    }
                }
                str=s;
            }
        }
        return str;
    }
}