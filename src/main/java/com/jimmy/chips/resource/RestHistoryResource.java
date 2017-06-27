package com.jimmy.chips.resource;

import com.jimmy.chips.entity.Action;
import com.jimmy.chips.entity.ActionType;
import com.jimmy.chips.entity.History;
import com.jimmy.chips.service.ActionService;
import com.jimmy.chips.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by eugen on 6/26/17.
 */
@RestController
@RequestMapping(value = "/history")
public class RestHistoryResource {

    final private HistoryService historyService;

    @Autowired
    public RestHistoryResource(HistoryService historyService) {
        this.historyService = historyService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void insertHistory(@RequestBody History history) {
        history.setDate(new Date());
        historyService.insert(history);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHistoryItem(@PathVariable String id) {
        historyService.deleteHistory(id);
    }

    @GetMapping(value = "/value")
    public Long getValue(){
        return historyService.getValue();
    };



}
