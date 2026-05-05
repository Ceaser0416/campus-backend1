package lk.icptechnologies.carergo.campusbackend.controller;

import lk.icptechnologies.carergo.campusbackend.entity.User;
import lk.icptechnologies.carergo.campusbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // In a real application, you would encrypt the password here
        return userRepository.save(user);
    }

    // Get all users or find by username
    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false) String username) {
        if (username != null && !username.isEmpty()) {
            Optional<User> user = userRepository.findByUsername(username);
            return user.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
        } else {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        }
    }

    // Update a user's email and password
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @RequestBody User userDetails) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword()); // Remember to encrypt in a real app
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Get a single user by ID - kept for convenience
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }
}
