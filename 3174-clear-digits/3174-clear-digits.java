class Solution {
    public String clearDigits(String s) {
        StringBuilder k=new StringBuilder(s);
        while(true){
            boolean flag=false;
            for(int i=0;i<k.length();i++){
                char ch=k.charAt(i);
                if(Character.isDigit(ch) && i!=0){
                   k.delete(i-1,i+1);
                   flag=true;
                   break;
                }
            }
            if(flag==false){
                break;
            }
        }
        return k.toString();
    }
}