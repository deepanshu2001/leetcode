class Twitter {
    class Tweet {
        int tweetId;
        int timestamp;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    private Map<Integer, List<Tweet>> postsMap;
    private Map<Integer, Set<Integer>> followerMap;
    private static int timestamp = 0; // Global timestamp

    public Twitter() {
        postsMap = new HashMap<>();
        followerMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        postsMap.putIfAbsent(userId, new ArrayList<>());
        postsMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        Set<Integer> followees = followerMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Include the user's own tweets

        for (int followeeId : followees) {
            List<Tweet> tweets = postsMap.getOrDefault(followeeId, new ArrayList<>());
            pq.addAll(tweets);
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerMap.containsKey(followerId)) {
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
