package com.example.springDemo.repository;

import com.example.springDemo.model.Friend;
import org.springframework.stereotype.Repository;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FriendsRepository {
    private List<Friend> friends = new ArrayList<>(List.of(
            new Friend("Alice", "New York", 25),
            new Friend("Bob", "Los Angeles", 30),
            new Friend("Charlie", "Chicago", 35)
    ));

    public List<Friend> getAllFriends() {
        return friends;
    }
//    public Friend[] getAllFriends() {
//        return friends.toArray(new Friend[0]);
//    }

    public Friend addFriend(Friend friend) {
        friends.add(friend);
        return friend;
    }

    public boolean deleteFriend(String name) {
        return friends.removeIf(friend -> friend.getName().equals(name));
    }

    public Friend updateFriend(String name, Friend updatedFriend) {
        for (Friend friend : friends) {
            if (friend.getName().equals(name)) {
                friend.setName(updatedFriend.getName());
                friend.setCity(updatedFriend.getCity());
                friend.setAge(updatedFriend.getAge());
                return friend;
            }
        }
        return null;
    }

    public Friend getFriendByName(String name) {
        for (Friend friend : friends) {
            if (friend.getName().equals(name)) {
                return friend;
            }
        }
        return null;
    }

    public Friend patchFriend(String name, Map<String, Object> updates) {
        for (Friend friend : friends) {
            if (friend.getName().equals(name)) {
                if (updates.containsKey("name")) {
                    friend.setName((String) updates.get("name"));
                }
                if (updates.containsKey("city")) {
                    friend.setCity((String) updates.get("city"));
                }
                if (updates.containsKey("age")) {
                    friend.setAge(((Number) updates.get("age")).intValue());
                }
                return friend;
            }
        }
        return null;
    }

}