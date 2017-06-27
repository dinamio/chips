package com.jimmy.chips.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by eugen on 6/26/17.
 */
@Data
@Document(collection = "history")
public class History {

    private String id;

    private Action action;

    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
