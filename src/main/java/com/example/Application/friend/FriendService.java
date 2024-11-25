package com.example.Application.friend;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository){
        this.friendRepository = friendRepository;
    }

    public void postFriend(Friend friend){
        friendRepository.save(friend);
    }

    public List<Long> getFriendsIds(Long userId) {
        System.out.println(friendRepository.findFriendIdsByUserId(userId));
        return friendRepository.findFriendIdsByUserId(userId);
    }
}
