package com.jimmy.chips.dao.impl;

import com.jimmy.chips.dao.ActionDao;
import com.jimmy.chips.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
