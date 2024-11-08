class Solution {
    public int maximumSwap(int num) {
        char ch[]=Integer.toString(num).toCharArray();
        int maxRightIndex[]=new int[ch.length];
        int n=ch.length;
        maxRightIndex[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            if(ch[i]>ch[maxRightIndex[i+1]]){
                maxRightIndex[i]=i;
            }
            else{
                maxRightIndex[i]=maxRightIndex[i+1];
            }
        }
        for(int i=0;i<n;i++){
            if(ch[i]<ch[maxRightIndex[i]]){
                char temp=ch[i];
                ch[i]=ch[maxRightIndex[i]];
                ch[maxRightIndex[i]]=temp;
                return Integer.parseInt(new String(ch));
            }
        }
        return num;
    }
}