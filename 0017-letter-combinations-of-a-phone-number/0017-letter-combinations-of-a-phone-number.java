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
    
    private List<String> ans = new ArrayList<>();
    private String phoneNum;

    public void f(StringBuilder s, int ind, String digits) {
        if (s.length() == phoneNum.length()) {
            ans.add(s.toString());
            return;
        }
        if (ind >= digits.length()) return;

        char ch = digits.charAt(ind);
        String mapped_num = letters.get(ch);
        for (char c : mapped_num.toCharArray()) {
            s.append(c);       
            f(s, ind + 1, digits); 
            s.deleteCharAt(s.length() - 1); 
        }
    }

    public List<String> letterCombinations(String digits) {
        ans.clear(); 
        if (digits == null || digits.isEmpty()) return ans;
        phoneNum = digits;
        f(new StringBuilder(), 0, digits);
        return ans;
    }
}
