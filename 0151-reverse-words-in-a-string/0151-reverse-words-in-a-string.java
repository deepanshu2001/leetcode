class Solution {
    public String reverseWords(String s) {
        s = s.trim(); 
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder ans = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            ans.append(list.get(j));
            if (j > 0) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}
