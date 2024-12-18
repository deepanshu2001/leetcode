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

    public List<String> letterCombinations(String digits) {
        ans.clear(); 
        if (digits == null || digits.isEmpty()) return ans;
        Queue<String> q = new LinkedList<>();
        q.add("");
        for (char ch : digits.toCharArray()) {
            String possible_comb = letters.get(ch);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String comb = q.poll();
                for (char letter : possible_comb.toCharArray()) {
                    q.add(comb + letter); 
                }
            }
        }
        ans.addAll(q);
        return ans;
    }
}
