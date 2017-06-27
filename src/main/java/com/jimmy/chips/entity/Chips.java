package com.jimmy.chips.entity;

import lombok.Data;

/**
 * Created by eugen on 6/26/17.
 */
@Data
public class Chips {

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private String _id;

    private Integer total;
}
