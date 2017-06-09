package com.jimmy.chips.dao;

import com.jimmy.chips.entity.Action;
import org.springframework.stereotype.Repository;

/**
 * Created by eugen on 6/9/17.
 */
public interface ActionDao {

    void insert(Action action);
}
