class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int max_ind = i;
            int max = s.charAt(i) - '0'; // Convert character to integer directly
            for (int j = i + 1; j < s.length(); j++) {
                if (max < s.charAt(j) - '0') { // Convert character to integer directly
                    max_ind = j;
                    max = s.charAt(j) - '0'; // Update max with the new maximum
                }
            }
            if (max_ind != i) {
                char[] ch = s.toCharArray();
                char temp = ch[i];
                ch[i] = ch[max_ind];
                ch[max_ind] = temp;
                s = new String(ch);
                break; // Stop after the first swap
            }
        }
        
        return Integer.parseInt(s);
    }
}
