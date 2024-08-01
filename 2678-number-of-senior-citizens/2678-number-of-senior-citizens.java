class Solution {
    public int countSeniors(String[] details) {
        int cnt=0;
        for(int i=0;i<details.length;i++){
            String s=details[i];
           
            char a=s.charAt(11);
            char b=s.charAt(12);
            int n1=a-'0';
            int n2=b-'0';
            if(n1==6 && n2>0){
                cnt++;
            }
            else if(n1>6){
                cnt++;
            }
        }
        return cnt;
    }
}