class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Create a map to store the list of websites visited by each user
        Map<String, List<String>> userWebsites = new HashMap<>();
        
        // Create a list to store the visit information
        List<int[]> visits = new ArrayList<>();
        
        // Populate the visits list with timestamp, username, and website index
        for (int i = 0; i < username.length; i++) {
            visits.add(new int[]{timestamp[i], i});
        }
        
        // Sort the visits based on timestamp
        Collections.sort(visits, (a, b) -> a[0] - b[0]);
        
        // Populate the userWebsites map with sorted website visits for each user
        for (int[] visit : visits) {
            String user = username[visit[1]];
            String site = website[visit[1]];
            userWebsites.computeIfAbsent(user, k -> new ArrayList<>()).add(site);
        }
        
        // Create a map to store the count of each pattern
        Map<String, Integer> patternCount = new HashMap<>();
        
        // Iterate over each user's website list
        for (List<String> sites : userWebsites.values()) {
            
            // Use a set to avoid counting duplicate patterns for the same user
            Set<String> patterns = new HashSet<>();
            
            // Generate all combinations of three websites
            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        
                        // Create a pattern string
                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        
                        // Add the pattern to the set
                        patterns.add(pattern);
                    }
                }
            }
            
            // Increment the count for each pattern
            for (String pattern : patterns) {
                patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
            }
        }
        
        // Initialize variables to track the best pattern and its score
        String bestPattern = "";
        int maxScore = 0;
        
        // Iterate over the patternCount map to find the pattern with the highest score
        for (Map.Entry<String, Integer> entry : patternCount.entrySet()) {
            String pattern = entry.getKey();
            int score = entry.getValue();
            
            // Update the best pattern if a higher score is found or if the score is the same but the pattern is lexicographically smaller
            if (score > maxScore || (score == maxScore && pattern.compareTo(bestPattern) < 0)) {
                bestPattern = pattern;
                maxScore = score;
            }
        }
        
        // Split the best pattern into a list of websites and return it
        return Arrays.asList(bestPattern.split(","));
    }
}