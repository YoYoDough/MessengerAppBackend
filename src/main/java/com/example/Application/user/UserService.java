package com.example.Application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private UserRepository userRepository;
    private static final Random random = new Random();

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String generateUniqueUsername(String name) {
        int randomNumber = 1000 + random.nextInt(9000); // Ensures a number between 1000 and 9999

        // Append the random number to the username
        return name + "#" + randomNumber;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void postUsers(User user) {
        String uniqueName = generateUniqueUsername(user.getName());
        user.setName(uniqueName);
        System.out.println(user);
        userRepository.save(user);
    }

    public Optional<User> getUserWithEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User authenticateUser(String email, String password) {
        System.out.println("Authenticating User");
        User user = userRepository.findUserByEmail(email).get();
        if (user != null && user.getPassword().equals(password)) {
            return user; // Return user if credentials match
        }
        return null; // Return null if credentials do not match
    }
}
