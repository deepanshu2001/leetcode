class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int n=s.length();
        //calculating how many sections required
        //2*numsrows-2 is the number of characters in each section;
        int sections=(int)Math.ceil(n/(2*numRows-2.0));
        int numCols=sections*(numRows-1);

        char ch[][]=new char[numRows][numCols];
        for(char []arr:ch){
            Arrays.fill(arr,' ');
        }
        int i=0;
        int currRow=0;
        int currCol=0;
        
        while(i<s.length()){
            //first going down
            while(currRow<numRows && i<n){
                ch[currRow][currCol]=s.charAt(i);
                i++;
                currRow++;
            }
            currRow-=2;
            currCol++;
            while(currRow>0 && currCol<numCols && i<n){
                ch[currRow][currCol]=s.charAt(i);
                i++;
                currRow--;
                currCol++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char arr[]:ch){
            for(char c:arr){
                if(c!=' '){
                   sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}