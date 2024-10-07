class Solution {
    public int romanToInt(String s) {
        int i=s.length()-1;
        int ans=0;
        while(i>=0){
            char ch=s.charAt(i);
            if(ch=='I'){
                ans+=1;
                i--;
            }
            if(ch=='V'){
                if(i>0 && s.charAt(i-1)=='I'){
                    ans+=4;
                    i=i-2;
                }
                else{
                    ans+=5;
                    i--;
                }
            }
            if(ch=='X'){
                if(i>0 && s.charAt(i-1)=='I'){
                    ans+=9;
                    i=i-2;
                }
                else{
                    ans+=10;
                    i--;
                }
            }
            if(ch=='L'){
                if(i>0 && s.charAt(i-1)=='X'){
                    ans+=40;
                    i=i-2;
                }
                else{
                    i=i-1;
                    ans+=50;
                }
            }
            if(ch=='C'){
                if(i>0 && s.charAt(i-1)=='X'){
                    ans+=90;
                    i=i-2;
                }
                else{
                    i=i-1;
                    ans+=100;
                }
            }
            if(ch=='D'){
                if(i>0 && s.charAt(i-1)=='C'){
                    ans+=400;
                    i=i-2;
                }
                else{
                    ans+=500;
                    i--;
                }
            }
            if(ch=='M'){
                if(i>0 && s.charAt(i-1)=='C'){
                    ans+=900;
                    i=i-2;
                }
                else{
                    i--;
                    ans+=1000;
                }
            }
        }
        return ans;
    }
}