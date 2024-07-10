package com.api.crud.Services;

import com.api.crud.Models.User_Model;
import com.api.crud.Repositories.I_User_Repository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class User_Services {
    @Autowired
    I_User_Repository userRepository;

    public ArrayList<User_Model> getUsers() {
        return (ArrayList<User_Model>) userRepository.findAll();
    }

    public User_Model save_user(User_Model user) {
        return this.userRepository.save(user);
    }

    public Optional<User_Model> get_user_id(UUID id) {
        return this.userRepository.findById(id);
    }

    public Optional<User_Model> update_by_id(User_Model user, UUID id) {
        Optional<User_Model> exist_user = this.userRepository.findById(id);
        if (exist_user.isPresent()) {
            User_Model user_by_id = exist_user.get();
            user_by_id.setFirs_name(user.getFirs_name());
            user_by_id.setGmail(user.getGmail());
            user_by_id.setLast_name(user.getLast_name());
            this.userRepository.save(user_by_id);
            return Optional.of(user_by_id);
        }else{
            return Optional.empty();
        }
    }
    public Boolean delete_user(UUID id){
        try{
            this.userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


