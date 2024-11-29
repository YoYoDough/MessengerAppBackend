package com.example.Application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        System.out.println(userService.getUsers());
        return userService.getUsers();
    }

    @GetMapping("/input")
    public ResponseEntity<?> getUsersFromInput(){
        System.out.println(userService.getUsers());

        List<User> users = userService.getUsers();
        if (users.size() > 0){
            return ResponseEntity.ok(users);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found!");
        }
    }

    @GetMapping("/exists")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        Optional<User> existingUser = userService.getUserWithEmail(email);

        // If the user is found, return the user object
        if (existingUser.isPresent()) {
            return ResponseEntity.ok(existingUser.get());
        }
        // If not found, return a 404 Not Found status
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
        // Check if the user exists and verify the password
        System.out.println(loginRequest.toString());
        User user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user); // Successful login, return user data
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized if credentials are incorrect
        }
    }

    @PostMapping("/self")
    public ResponseEntity<Long> getUserId(@RequestBody Name selfName){
        System.out.println(selfName.toString());
        String userName = selfName.getName() + selfName.getTag();
        System.out.println(userName);
        Long userId = userService.getUserId(userName);
        return ResponseEntity.ok(userId);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.postUsers(user);
    }
}
