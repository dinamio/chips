package com.jimmy.chips.service;

import com.jimmy.chips.dao.HistoryDao;
import com.jimmy.chips.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eugen on 6/26/17.
 */
@Service
public class HistoryService {

    @Autowired
    HistoryDao historyDao;

    public void insert(History history) {
        historyDao.insert(history);
    }

    public List<History> getAllHistory() {
        return historyDao.findAll();
    }

    public void deleteHistory(String id) {
        historyDao.delete(id);
    }

    public Long getValue() {
        return historyDao.countValue();
    }
}
