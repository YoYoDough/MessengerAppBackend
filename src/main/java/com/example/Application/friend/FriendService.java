package com.example.Application.friend;

import org.springframework.stereotype.Service;

@Service
public class FriendService {
    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository){
        this.friendRepository = friendRepository;
    }

    public void postFriend(Friend friend){
        friendRepository.save(friend);
    }
}
