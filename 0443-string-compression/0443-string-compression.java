class Solution {
    public int compress(char[] chars) {
        int i=0;
        int ind=0;
        while(i<chars.length){
            int len=1;
            while(i+len<chars.length && chars[i+len]==chars[i]){
                len++;
            }
            chars[ind]=chars[i];
            ind++;
            if(len>1){
                for(char c:Integer.toString(len).toCharArray()){
                    chars[ind]=c;
                    ind++;
                }
            }
            i+=len;

        }
        return ind;
    }
}