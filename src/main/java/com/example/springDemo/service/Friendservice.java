package com.example.springDemo.service;

import com.example.springDemo.model.Friend;
import com.example.springDemo.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import java.util.List;

@Component
public class Friendservice {
    @Autowired
    private FriendsRepository friendsRepository;

    public List<Friend> getAllFriends() {
        return friendsRepository.getAllFriends();
    }

    public Friend addFriend(Friend friend) {
        return friendsRepository.addFriend(friend);
    }

    public boolean deleteFriend(String name) {
        return friendsRepository.deleteFriend(name);
    }

    public Friend updateFriend(String name, Friend updatedFriend) {
        return friendsRepository.updateFriend(name, updatedFriend);
    }

    public Friend getFriendByName(String name) {
        return friendsRepository.getFriendByName(name);
    }


    public Friend patchFriend(String name, Map<String, Object> updates) {
        return friendsRepository.patchFriend(name, updates);
    }
}
