class Solution {

    public int maximumSwap(int num) {
        char ch[]=Integer.toString(num).toCharArray();
        int max_index=-1;
        int idx1=-1;
        int idx2=-1;
        for(int i=ch.length-1;i>=0;i--){
            if(max_index==-1||ch[i]>ch[max_index]){
                max_index=i;
            }
            else if(ch[i]<ch[max_index]){
                idx1=i;
                idx2=max_index;
            }
        }
        if(idx1!=-1 && idx2!=-1){
            char temp=ch[idx1];
            ch[idx1]=ch[idx2];
            ch[idx2]=temp;
            String k=new String(ch);
            return Integer.parseInt(k);
        }
        return num;
    }
}