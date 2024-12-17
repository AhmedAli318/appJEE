package org.example.donationms.service;

import org.example.donationms.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "userMS")
public interface UserRestClient {
    @GetMapping(path = "/users/{id}")
    User getUserById(@PathVariable Long id);
    @GetMapping(path = "/users")
    List<User> getUsers();
}
