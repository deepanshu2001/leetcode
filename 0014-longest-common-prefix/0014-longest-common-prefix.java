class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        return lcs(strs,0,strs.length-1);
    }
    public String lcs(String []strs,int l,int r){
        if(l==r){
            return strs[l];
        }
        else{
            int mid=(l+r)/2;
            String left=lcs(strs,l,mid);
            String right=lcs(strs,mid+1,r);
            return commonPrefix(left,right);
        }
       
    }
     public String commonPrefix(String left,String right){
            int min=Math.min(left.length(),right.length());
            for(int i=0;i<min;i++){
                if(left.charAt(i)!=right.charAt(i)){
                    return left.substring(0,i);
                }
            }
            return left.substring(0,min);
        }
}