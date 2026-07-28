package com.example.springDemo.controller;

import com.example.springDemo.model.Friend;
import com.example.springDemo.service.Friendservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
@RestController
public class MyRESTcontroller {


    @Autowired
    private Friendservice friendservice;

    @GetMapping("/all")
    public List<Friend> getAllFriends() {
        return friendservice.getAllFriends();
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<Friend> getFriendByName(@PathVariable String name) {
        Friend friend = friendservice.getFriendByName(name);
        if (friend == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend not found with name: " + name);
        }
        return ResponseEntity.ok(friend);
    }

    @PostMapping("/add")
    public Friend addFriend(@RequestBody Friend friend) {
        return friendservice.addFriend(friend);
    }

    @DeleteMapping("/delete/{name}")
    public boolean deleteFriend(@PathVariable String name) {
        return friendservice.deleteFriend(name);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<Friend> updateFriend(@PathVariable String name, @RequestBody Friend friend) {
        Friend updatedFriend = friendservice.updateFriend(name, friend);
        if (updatedFriend == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend not found with name: " + name);
        }
        return ResponseEntity.ok(updatedFriend);
    }

    @PatchMapping("/patch/{name}")
    public ResponseEntity<Friend> patchFriend(@PathVariable String name, @RequestBody Map<String, Object> updates) {
        Friend patchedFriend = friendservice.patchFriend(name, updates);
        if (patchedFriend == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend not found with name: " + name);
        }
        return ResponseEntity.ok(patchedFriend);

    }
}

