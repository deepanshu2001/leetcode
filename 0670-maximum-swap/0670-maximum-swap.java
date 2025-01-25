class Solution {
    public int maximumSwap(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        
        // Array to store the index of the maximum digit to the right of each position
        int[] rightMaxIndex = new int[n];
        rightMaxIndex[n - 1] = n - 1;
        
        // Populate the rightMaxIndex array
        for (int i = n - 2; i >= 0; i--) {
            rightMaxIndex[i] = (ch[i] < ch[rightMaxIndex[i + 1]]) ? rightMaxIndex[i + 1] : i;
        }

        // Traverse the array to find the first position where a swap increases the number
        for (int i = 0; i < n; i++) {
            if (ch[i] < ch[rightMaxIndex[i]]) {
                // Perform the swap
                char temp = ch[i];
                ch[i] = ch[rightMaxIndex[i]];
                ch[rightMaxIndex[i]] = temp;
                
                // Convert back to integer and return
                return Integer.parseInt(new String(ch));
            }
        }
        
        // If no swap can improve the number, return the original number
        return num;
    }
}
