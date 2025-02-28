class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int first=0;
        int second=0;
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>2){
                    return false;
                }
                else if(diff==1){
                    first=i;
                }
                else{
                    second=i;
                }
            }
        }
        return (s1.charAt(first)==s2.charAt(second) && s1.charAt(second)==s2.charAt(first));
    }
}