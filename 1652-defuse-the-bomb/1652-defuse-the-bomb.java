class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n * 2];

        // Copy the array twice to handle circular wrapping
        for (int i = 0; i < n; i++) {
            arr[i] = code[i];
            arr[i + n] = code[i]; // Duplicate the array
        }

        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            if (k == 0) {
                result[j] = 0;
            } 
            else if (k > 0) {
                int sum = 0;
                for (int p = j + 1; p <= j + k; p++) {
                    sum += arr[p];
                }
                result[j] = sum;
            } 
            else { // k < 0
                int sum = 0;
                for (int p = j + n - 1; p >= j + n + k; p--) {
                    sum += arr[p];
                }
                result[j] = sum;
            }
        }
        return result;
    }
}
