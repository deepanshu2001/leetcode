class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Step 1: Combine and sort data based on timestamp
        int n = username.length;
        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(new int[]{timestamp[i], i}); // Store timestamp and index
        }
        data.sort((a, b) -> a[0] - b[0]); // Sort by timestamp

        // Step 2: Group websites visited by each user
        Map<String, List<String>> userWebsites = new HashMap<>();
        for (int[] entry : data) {
            int index = entry[1];
            String user = username[index];
            String web = website[index];
            userWebsites.computeIfAbsent(user, k -> new ArrayList<>()).add(web);
        }

        // Step 3: Count patterns of length 3
        Map<List<String>, Integer> patternCount = new HashMap<>();
        for (List<String> websites : userWebsites.values()) {
            if (websites.size() < 3) continue; // Skip if less than 3 visits
            Set<List<String>> uniquePatterns = new HashSet<>();
            for (int i = 0; i < websites.size(); i++) {
                for (int j = i + 1; j < websites.size(); j++) {
                    for (int k = j + 1; k < websites.size(); k++) {
                        uniquePatterns.add(Arrays.asList(websites.get(i), websites.get(j), websites.get(k)));
                    }
                }
            }
            for (List<String> pattern : uniquePatterns) {
                patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
            }
        }

        // Step 4: Find the most visited pattern
        List<String> result = null;
        int maxCount = 0;
        for (Map.Entry<List<String>, Integer> entry : patternCount.entrySet()) {
            List<String> pattern = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && (result == null || pattern.toString().compareTo(result.toString()) < 0))) {
                result = pattern;
                maxCount = count;
            }
        }

        return result;
    }
}
