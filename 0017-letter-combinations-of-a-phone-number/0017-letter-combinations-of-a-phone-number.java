

class Solution {
    private Map<Character, String> letters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    List<String> ans=new ArrayList<>();
    public void f(String s,String digits){
        if(digits.length()==0){
            ans.add(s);
            return;
        }
        char ch=digits.charAt(0);
        String str=letters.get(ch);
        for(int i=0;i<str.length();i++){
            f(s+str.charAt(i),digits.substring(1));
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        f("",digits);
        return ans;
    }
}