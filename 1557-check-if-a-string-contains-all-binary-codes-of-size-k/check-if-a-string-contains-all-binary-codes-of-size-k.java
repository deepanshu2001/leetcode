class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        for(int i=0,j=k-1;j<s.length();i++,j++){
            String str=s.substring(i,j+1);
            set.add(str);
        }
        if(set.size()==Math.pow(2,k)){
            return true;
        }
        return false;
    }
}