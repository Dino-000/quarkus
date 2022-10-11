package com.axonactive.agileterm.service;

import com.axonactive.agileterm.dao.TopicDAO;
import com.axonactive.agileterm.entity.TopicEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TopicService {

    @Inject
    private TopicDAO topicDAO;

    @Inject
    private Logger log;

    public List<TopicEntity> getAll() {
        return topicDAO.findAll();
    }

    public TopicEntity findTopicById(Integer topicId) {
        TopicEntity topicEntity = topicDAO.findById(topicId);
        if (topicEntity == null) {
            log.error("Not Found Topic");
        }
        return topicEntity;
    }

    public TopicEntity save(TopicEntity topicInput) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setName(topicInput.getName());
        topicEntity.setColor(topicInput.getColor());
        return topicDAO.save(topicEntity);
    }



}

