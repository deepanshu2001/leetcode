class Solution {
    public void bs(String searchWord, String[] products, List<String> list) {
        int s = 0;
        int e = products.length - 1;
        int startIndex = -1;

        // Binary search to find the first occurrence of a prefix match
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (products[mid].startsWith(searchWord)) {
                startIndex = mid;
                e = mid - 1; // Continue searching on the left to find the first match
            } else if (products[mid].compareTo(searchWord) < 0) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        // Collect up to 3 suggestions from the found starting point
        if (startIndex != -1) {
            int count = 0;
            for (int i = startIndex; i < products.length && count < 3; i++) {
                if (products[i].startsWith(searchWord)) {
                    list.add(products[i]);
                    count++;
                } else {
                    break;
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            bs(searchWord.substring(0, i), products, list);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
