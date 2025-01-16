class Solution {
    public int[] findLPS(String pattern){
        int m=pattern.length();
        int LPS[]=new int[m];
        LPS[0]=0;
        int j=1;
        int i=0;
        while(j<m){
            if(pattern.charAt(i)==pattern.charAt(j)){
                i++;
                LPS[j]=i;
                j++;
            }
            else{
                if(i!=0){
                    i=LPS[i-1];
                }
                else{
                    LPS[j]=0;
                    j++;
                }
            }
        }
        return LPS;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int []LPS=findLPS(goal);
        s=s+s;
        int m=goal.length();
        int n=s.length();
        int i=0;
        int j=0;
        while(i<n){
            if(s.charAt(i)==goal.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                return true;
            }
            else if(i<n && s.charAt(i)!=goal.charAt(j)){
                if(j!=0){
                    j=LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }
}