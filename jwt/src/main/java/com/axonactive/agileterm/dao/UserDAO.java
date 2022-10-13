package com.axonactive.agileterm.dao;

import com.axonactive.agileterm.entity.Role;
import com.axonactive.agileterm.entity.UserEntity;

import java.util.List;

public interface UserDAO {
    List<UserEntity> getAll();

    UserEntity save(UserEntity userEntity);

    Role getRoleFromUserName (String userName);

}
