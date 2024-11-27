
import java.math.BigInteger;class Solution {
    public String addStrings(String num1, String num2) {
        char []ch1=num1.toCharArray();
        char ch2[]=num2.toCharArray();
        int l1=ch1.length;
        int l2=ch2.length;
        int i=l1-1;
        int j=l2-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int a=0;
            int b=0;
            if(i>=0){
                a=ch1[i]-'0';
            }
            if(j>=0){
               b=ch2[j]-'0';
            }
            
            
            int c=a+b+carry;
            if(c>9){
                carry=1;
            }
            else{
                carry=0;
            }
            sb.append(c%10);
            i--;
            j--;
        }
        if(carry==1){
            return sb.append(1).reverse().toString();
        }
        return sb.reverse().toString();
        
    }
}