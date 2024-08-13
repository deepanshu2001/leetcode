class Solution {
    public List<String> helper(String p,String up){
        if(up.length()==0){
            List<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<String> ans=new ArrayList<>();
        int digit=up.charAt(0)-'0';
        int i=(digit-2)*3;
        if(digit>7){
            i++;
        }
        int len=i+3;
        if(digit==7 || digit==9){
            len++;
        }
        for(;i<len;i++){
            char ch=(char)('a'+i);
            ans.addAll(helper(p+ch,up.substring(1)));
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            List<String> ans=new ArrayList<>();
            return ans;
        }
        List<String> ans=new ArrayList<>();
        ans=helper("",digits);
        return ans;
    }
}