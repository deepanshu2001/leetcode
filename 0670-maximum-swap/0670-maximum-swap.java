class Solution {
    public int maximumSwap(int num) {
        char ch[]=Integer.toString(num).toCharArray();
        int n=ch.length;
        int rightMaxIndex[]=new int[n];
        rightMaxIndex[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            rightMaxIndex[i]=(ch[i]>ch[rightMaxIndex[i+1]])?i:rightMaxIndex[i+1];
        }

        for(int i=0;i<n;i++){
            if(ch[i]<ch[rightMaxIndex[i]]){
                char temp=ch[i];
                ch[i]=ch[rightMaxIndex[i]];
                ch[rightMaxIndex[i]]=temp;
                String str=new String(ch);
                return Integer.parseInt(str);
                
            }
        }
        return num;
    }
}