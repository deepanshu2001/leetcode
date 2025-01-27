class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");

        for (int k = 2; k <= n; k++) {
            StringBuilder temp = new StringBuilder();
            int i = 0;

            while (i < sb.length()) {
                char currentChar = sb.charAt(i);
                int count = 0;
                while (i < sb.length() && sb.charAt(i) == currentChar) {
                    count++;
                    i++;
                }
                temp.append(count);
                temp.append(currentChar);
            }
            sb = temp;
        }
        return sb.toString();
    }
}
