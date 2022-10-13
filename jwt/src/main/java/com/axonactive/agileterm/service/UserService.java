package com.axonactive.agileterm.service;

import com.axonactive.agileterm.dao.UserDAO;
import com.axonactive.agileterm.entity.Role;
import com.axonactive.agileterm.entity.UserEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped

public class UserService {
    @Inject
    private UserDAO userDAO;

    @Inject
    private Logger log;

    public List<UserEntity> getAll() {
        return userDAO.getAll();
    }

    ;

    public UserEntity save(UserEntity userEntity) {
        return userDAO.save(userEntity);
    }

    ;

    public Role getRoleFromUserName(String userName) {

        return userDAO.getRoleFromUserName(userName);
    }

    ;
}
