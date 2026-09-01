class User {
    int id;
    HashSet<Integer> followings;
    LinkedList<Tweet> tweets;

    User(int id) {
        this.id = id;

        followings = new HashSet<>();
        followings.add(id);

        tweets = new LinkedList<>();
    }

    void follow(int id) {
        followings.add(id);
    }

    void unfollow(int id) {
        followings.remove(id);
    }

    void post(int id, int timeStamp) {
        tweets.add(0, new Tweet(id, timeStamp));
    }
}

class Tweet {
    int id;
    int timeStamp;

    Tweet(int id, int timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }
}

class Twitter {
    HashMap<Integer, User> users = new HashMap<>();
    int timeStamp = 0;

    void createUser(int userId) {
        if (!users.containsKey(userId))
            users.put(userId, new User(userId));
    }

    void follow(int followerId, int followingId) {
        createUser(followerId);
        createUser(followingId);

        users.get(followerId).follow(followingId);
    }

    void unfollow(int followerId, int followingId) {
        createUser(followerId);

        users.get(followerId).unfollow(followingId);
    }

    void postTweet(int userId, int tweetId) {
        createUser(userId);

        User user = users.get(userId);
        user.post(tweetId, timeStamp);

        timeStamp++;
    }

    List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        User user = users.get(userId);

        if (user == null)
            return result;

        HashSet<Integer> followings = user.followings;
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.timeStamp, a.timeStamp));

        for (int followingId : followings) {
            User following = users.get(followingId);

            if (following != null) {
                int count = 0;

                for (Tweet tweet : following.tweets) {
                    if (count == 10)
                        break;

                    maxHeap.offer(tweet);
                    count++;
                }
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int tweetId = maxHeap.poll().id;
            result.add(tweetId);
        }

        return result;
    }
}