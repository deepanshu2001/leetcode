class Solution {
    private long halfToPalindrome(long left, boolean even) {
        long resultNum = left;
        if (!even) {
            left = left / 10;
        }
        while (left > 0) {
            int digit = (int) (left % 10);
            resultNum = (resultNum * 10) + digit;
            left /= 10;
        }
        return resultNum;
    }
    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len / 2;
        long firstHalf = Long.parseLong(n.substring(0, len % 2 == 0 ? mid : mid + 1));
        List<Long> possibleResults = new ArrayList<>();
        possibleResults.add(halfToPalindrome(firstHalf, len % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf + 1, len % 2 == 0));
        possibleResults.add(halfToPalindrome(firstHalf - 1, len % 2 == 0));
        possibleResults.add((long) Math.pow(10, len - 1) - 1);  // Edge case like 999...
        possibleResults.add((long) Math.pow(10, len) + 1);      // Edge case like 100...001
        long diff = Long.MAX_VALUE;
        long result = 0;
        long originalNum = Long.parseLong(n);

        // Find the closest palindrome
        for (long num : possibleResults) {
            if (num == originalNum) continue;
            if (Math.abs(num - originalNum) < diff) {
                diff = Math.abs(num - originalNum);
                result = num;
            } else if (Math.abs(num - originalNum) == diff) {
                result = Math.min(result, num);
            }
        }

        return String.valueOf(result);
    }
}