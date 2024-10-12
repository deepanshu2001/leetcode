class Solution {
    public void f(String p,String up, List<String> ans){
      if(up.length()==0){
        ans.add(p);
        return ;
      }
      int digit=up.charAt(0)-'0';
      int starting_index=(digit-2)*3;
      //beacuse 7 has 4 letters,so we need to add that into our cal
      if(digit>7){
        starting_index++;
      }
      int size=starting_index+3;
      if(digit==7||digit==9){
        size++;
      }
      for(;starting_index<size;starting_index++){
        char ch=(char)('a'+starting_index);
        f(p+ch,up.substring(1),ans);
      }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        f("",digits,ans);
        return ans;
    }
}