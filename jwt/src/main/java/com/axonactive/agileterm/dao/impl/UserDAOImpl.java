package com.axonactive.agileterm.dao.impl;

import com.axonactive.agileterm.dao.UserDAO;
import com.axonactive.agileterm.entity.Role;
import com.axonactive.agileterm.entity.UserEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class UserDAOImpl implements UserDAO {

    @Inject
    Logger log;
    @PersistenceContext(name = "agileterm")
    EntityManager em;

    @Override
    public List<UserEntity> getAll() {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();

    }


    @Override
    public UserEntity save(UserEntity userEntity) {
        return this.em.merge(userEntity);
    }

    @Override
    public Role getRoleFromUserName(String name) {
        return em.createQuery("SELECT u.role FROM UserEntity u WHERE u.username = :name", Role.class)
                .setParameter("name",name).getSingleResult();
    }
}
