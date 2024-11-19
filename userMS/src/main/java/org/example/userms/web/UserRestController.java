package org.example.userms.web;


import org.example.userms.entities.User;
import org.example.userms.repos.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/xml")
public class UserRestController {
    private UserRepo userRepo;
    public UserRestController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> userList(){
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le compte n'existe pas!",id)));
    }

    @PostMapping("/users/{id}")
    public User saveUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User userById = userRepo.findById(id).get();
        if(user.getFirstName() !=null) userById.setFirstName(user.getFirstName());
        if(user.getLastName() !=null) userById.setLastName(user.getLastName());
        if(user.getEmail() !=null) userById.setEmail(user.getEmail());
        if(user.getBirthDate() !=null) userById.setBirthDate(user.getBirthDate());
        if(user.getCIN() !=null) userById.setCIN(user.getCIN());
        if(user.getPhoneNumber() !=null) userById.setPhoneNumber(user.getPhoneNumber());
        if(user.getAddress() !=null) userById.setAddress(user.getAddress());
        if(user.getGender() !=null) userById.setGender(user.getGender());
        return userRepo.save(userById);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
