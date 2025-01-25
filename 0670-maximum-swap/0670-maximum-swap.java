class Solution {
    public int maximumSwap(int num) {
        String numstr=Integer.toString(num);
        int n=numstr.length();
        int ans=num;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               char ch[]=numstr.toCharArray();
               char temp=ch[i];
               ch[i]=ch[j];
               ch[j]=temp;
               int new_num=Integer.parseInt(new String(ch));
               ans=Math.max(ans,new_num);
            }
        }
        return ans;
    }
}