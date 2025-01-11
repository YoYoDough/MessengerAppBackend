package com.example.Application.friend;

import com.example.Application.user.User;
import com.example.Application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/friends")
@CrossOrigin("http://localhost:3000")
public class FriendController {
    private FriendService friendService;
    private UserService userService;

    @Autowired
    public FriendController(FriendService friendService, UserService userService){
        this.userService = userService;
        this.friendService = friendService;
    }

    @PostMapping("/friendrequest")
    public ResponseEntity<?> addFriend(@RequestBody Friend friend, @RequestParam String email){
        Optional<User> user = userService.getUserWithEmail(email);
        if (user.isPresent()){
            friend.setUser_id(user.get().getId());
        }
        friendService.postFriend(friend);
        return ResponseEntity.ok("Friend request sent!");
    }

    @GetMapping("/requested")
    public ResponseEntity<?> questionFriendship(@RequestParam String email){
        System.out.println(email);
        Optional<User> user = userService.getUserWithEmail(email);

        Long userId= 0l;
        if (user.isPresent())
        {
            userId = user.get().getId();
        }
        System.out.println("UserId: " + userId); // Debugging step
        List<Long> friends = friendService.getFriendsIds(userId);
        System.out.println("Friends: " + friends); // Debugging step
        return ResponseEntity.ok(friends);
    }

    //@GetMapping("/count")
    //public ResponseEntity<?> getFriendRequestCount(){
        //int count = friendService.getFriendRequestCount();
        //return ResponseEntity.ok(count);
    //}
}
