package com.api.crud.Repositories;

import com.api.crud.Controllers.User_Controller;
import com.api.crud.Models.User_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface I_User_Repository extends JpaRepository<User_Model, UUID> {

}
