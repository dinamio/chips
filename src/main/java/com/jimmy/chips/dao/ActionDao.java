package com.jimmy.chips.dao;

import com.jimmy.chips.entity.Action;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eugen on 6/9/17.
 */
public interface ActionDao {

    void insert(Action action);

    List<Action> findAll();

    Action findOne(String actionId);

    void delete(String id);
}
