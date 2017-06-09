package com.jimmy.chips.dao.impl;

import com.jimmy.chips.dao.ActionDao;
import com.jimmy.chips.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eugen on 6/9/17.
 */
@Repository
public class ActionDaoImpl implements ActionDao {

    @Autowired
    MongoTemplate template;

    @Override
    public void insert(Action action) {
        template.insert(action);
    }

    @Override
    public List<Action> findAll() {
        return template.findAll(Action.class);
    }

    @Override
    public Action findOne(String actionId) {
        return template.findById(actionId,Action.class);
    }

    @Override
    public void delete(String id) {
        template.remove(new Query(Criteria.where("id").is(id)),Action.class);
    }
}
