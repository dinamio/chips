package com.jimmy.chips.resource;

import com.jimmy.chips.entity.Action;
import com.jimmy.chips.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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
    public void insertAction(@RequestBody Action action) {
        actionService.insert(action);
    }

    @GetMapping
    public List<Action> getAllActions() {
       return actionService.getAllActions();
    }

    @GetMapping(value = "/{id}")
    public Action getAction(@PathVariable String id) {
        return actionService.getAction(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAction(@PathVariable String id) {
        actionService.deleteAction(id);
    }
}
