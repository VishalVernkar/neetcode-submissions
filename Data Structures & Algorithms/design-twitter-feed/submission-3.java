class Twitter {
    int time = 0;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int []>> tweets;

    public Twitter() {
        followMap = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(Integer followee : followMap.get(userId)){
            List<int[]> followeeTweets = tweets.get(followee);
            if(followeeTweets == null) continue;
            for(int[] tweet : followeeTweets){
                maxHeap.add(tweet);
            }
        }

        List<Integer> res = new ArrayList<>();
        int i = 10;
        while(i > 0 && !maxHeap.isEmpty()){
            i--;
            res.add(maxHeap.poll()[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
         if (followMap.containsKey(followerId) && followeeId != followerId) {
                followMap.get(followerId).remove(followeeId);
            }
    }
}

// 6:43 - 6:58

// getNewsFeed
// when a feed requested - I need to get top 10 tweets based on timw
// I need to get them from user + users he follows
// most recent tweets -> we can use a heap
// add all the tweets from himself and users  to heap
// then only get top 10

// algo
// time = 0 - time stamp
// creat a map - user -> following list set
// creat a map - user -> tweet list

// postTweet
// get user tweet list - add tweet

// getNewsFeed
// create a heap
// add user to follow map
// traverse each user from follow map - get their tweet list
// add them to heap
// then -> get top 10 

// follow
// add following to user list

// unfollow
// remove following from user list











// first I'll solve all the problems - then later today I'll take optimal one