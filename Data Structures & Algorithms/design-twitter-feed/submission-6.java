class Twitter {
    Map<Integer, List<int[]>> posts;
    Map<Integer, Set<Integer>> followMap;
    int timeStamp;

    public Twitter() {
        posts = new HashMap<>();
        followMap = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        posts.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, timeStamp});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId : followMap.get(userId)){
            List<int[]> list = posts.getOrDefault(followeeId, new ArrayList<>());
            if(list.isEmpty()) continue;
            int[] last = list.get(list.size() - 1);
            maxHeap.offer(new int[]{last[1], last[0], followeeId, list.size() - 1});
        }

        for(int i = 0; i < 10 && !maxHeap.isEmpty(); i++){
            int[] latest = maxHeap.poll();
            res.add(latest[1]);
            if(latest[3] > 0){
                int[] prev = posts.get(latest[2]).get(latest[3] - 1);
                maxHeap.offer(new int[]{prev[1], prev[0], latest[2], latest[3] - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}

// users - posts list
// users - followers set