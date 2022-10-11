package com.axonactive.agileterm.dao.impl;

import com.axonactive.agileterm.dao.TopicDAO;
import com.axonactive.agileterm.entity.TopicEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TopicDAOImpl implements TopicDAO {
    @PersistenceContext(name = "agileterm")
    EntityManager em;

    @Override
    public List<TopicEntity> findAll() {
        return em.createQuery("SELECT t FROM TopicEntity t", TopicEntity.class).getResultList();
    }

    @Override
    public TopicEntity save(TopicEntity topicEntity) {
        return this.em.merge(topicEntity);
    }

    @Override
    public TopicEntity findById(Integer topicId) {
        List<TopicEntity> topicEntityList = em.createQuery("SELECT t FROM TopicEntity t WHERE t.id = :topicId", TopicEntity.class)
                .setParameter("topicId", topicId).getResultList();
        if (!topicEntityList.isEmpty())
            return topicEntityList.get(0);
        return null;
    }
    }
