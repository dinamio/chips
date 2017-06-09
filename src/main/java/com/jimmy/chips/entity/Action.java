package com.jimmy.chips.entity;

import com.mongodb.annotations.NotThreadSafe;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * Created by eugen on 6/9/17.
 */
@Data
@Document(collection = "actions")
public class Action {

    private String id;

    private String text;

    private Integer points;

    private ActionType type;
}
