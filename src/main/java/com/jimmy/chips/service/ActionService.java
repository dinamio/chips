package com.jimmy.chips.service;

import com.jimmy.chips.dao.ActionDao;
import com.jimmy.chips.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eugen on 6/9/17.
 */
@Service
public class ActionService {

    @Autowired
    private ActionDao actionDao;

    public void insert(Action action) {
        actionDao.insert(action);
    }

    public List<Action> getAllActions() {
        return actionDao.findAll();
    }

    public Action getAction(String actionId) {
        return actionDao.findOne(actionId);
    }

    public void deleteAction(String id) {
        actionDao.delete(id);
    }
}
