class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch=sb.charAt(i);
            if(Character.isDigit(ch)){
                boolean flag=false;
                for(int j=i-1;j>=0;j--){
                    char new_ch=sb.charAt(j);
                    if(Character.isAlphabetic(new_ch)){
                        sb.setCharAt(j,'#');
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    break;
                }
                sb.setCharAt(i,'#');
            }
        }
        StringBuilder k=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch!='#'){
                k.append(ch);
            }
        }
        return k.toString();
    }
}