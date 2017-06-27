package com.jimmy.chips.dao;

import com.jimmy.chips.entity.Action;
import com.jimmy.chips.entity.ActionType;
import com.jimmy.chips.entity.History;

import java.util.List;

/**
 * Created by eugen on 6/26/17.
 */
public interface HistoryDao {

    void insert(History history);

    List<History> findAll();

    void delete(String id);

    Long countValue();
}
