class Solution {
    public List<String> partitionString(String s) {
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        String str="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            str+=ch;
            if(!set.contains(str)){
                ans.add(str);
                set.add(str);
                str=new String();
            }
        }
        return ans;
    }
}