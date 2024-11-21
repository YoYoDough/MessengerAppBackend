package com.example.Application.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/friends")
@CrossOrigin("http://localhost:3000")
public class FriendController {
    private FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService){
        this.friendService = friendService;
    }

    @PostMapping
    public void addFriend(@RequestBody Friend friend){
        friendService.postFriend(friend);
    }

}
