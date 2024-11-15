class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
int i = 0;

while (i < word.length()) {
    char ch = word.charAt(i);
    int cnt = 1;
    int j = i + 1;

    // Count consecutive occurrences of the same character, up to a maximum of 9
    while (j < word.length() && ch == word.charAt(j) && cnt < 9) {
        cnt++;
        j++;
    }

    sb.append(cnt);
    sb.append(ch);
    i = j;  // Move the pointer `i` to the position after the counted sequence
}

return sb.toString();

    }
}