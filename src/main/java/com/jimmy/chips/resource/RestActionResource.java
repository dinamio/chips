package com.jimmy.chips.resource;

import com.jimmy.chips.entity.Action;
import com.jimmy.chips.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eugen on 6/9/17.
 */
@RestController
@RequestMapping(value = "/action")
public class RestActionResource {

    final private ActionService actionService;

    @Autowired
    public RestActionResource(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping
    void insertAction(@RequestBody Action action) {
        actionService.insert(action);
    }
}
