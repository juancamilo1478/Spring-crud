package com.api.crud.Controllers;

import com.api.crud.Models.User_Model;
import com.api.crud.Services.User_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class User_Controller {
    @Autowired
    private User_Services userServices;

    @GetMapping
    public ArrayList<User_Model> getUsers() {
        return this.userServices.getUsers();
    }

    @PostMapping
    public User_Model save_user(@RequestBody User_Model user) {
        return this.userServices.save_user(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User_Model> get_user_by_id(@PathVariable UUID id) {
        return this.userServices.get_user_id(id);
    }

    @PutMapping
    public Optional<User_Model> put_user_by_id(@RequestBody User_Model user) {
        return this.userServices.update_by_id(user, user.getId());
    }

    @DeleteMapping(path = "/{id}")
    public String delete_user(@PathVariable UUID id) {
        Boolean response = this.userServices.delete_user(id);
        if (response) {
            return "Correct the user" + id + "Delete";
        } else {
            return "i can't delete user Error";
        }
    }
}
