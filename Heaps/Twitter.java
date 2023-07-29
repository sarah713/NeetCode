package Heaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
    Map<Integer, Set<Integer>> follows = new HashMap<>();
    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
    int cnt = 0;

    public void postTweet(int userId, int tweetId) {
        if (!follows.containsKey(userId))
            follows.put(userId, new HashSet<>());
        follows.get(userId).add(userId);

        if (!tweets.containsKey(userId))
            tweets.put(userId, new LinkedList<>());
        tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!follows.containsKey(userId))
            return new LinkedList<>();
        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        follows.get(userId).stream().filter(f -> tweets.containsKey(f)).forEach(f -> tweets.get(f).forEach(feed::add));

        List<Integer> res = new LinkedList<>();
        int cnt = 10;
        while (feed.size() > 0 && res.size() < 10) {
            res.add(feed.poll().id);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId))
            follows.put(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId) && followeeId != followerId)
            follows.get(followerId).remove(followeeId);
    }
}

class Tweet {
    int time;
    int id;

    Tweet(int time, int id) {
        this.time = time;
        this.id = id;
    }
}
