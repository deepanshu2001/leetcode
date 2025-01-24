class Solution {
    public String addBinary(String a, String b) {
        int n=a.length();
        int m=b.length();
        if(n<m){
            return addBinary(b, a);
        }
        int j=m-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(a.charAt(i)=='1'){
                carry++;
            }
            if(j>-1 && b.charAt(j)=='1'){
                carry++;
            }
            if(carry%2==0){
                sb.append(0);
            }
            else{
                sb.append(1);
            }
            carry=carry/2;
            j--;
        }
        if(carry==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}