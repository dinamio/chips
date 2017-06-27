package com.jimmy.chips.dao.impl;

import com.jimmy.chips.dao.HistoryDao;
import com.jimmy.chips.entity.Action;
import com.jimmy.chips.entity.Chips;
import com.jimmy.chips.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

/**
 * Created by eugen on 6/26/17.
 */
@Repository
public class HistoryDaoImpl implements HistoryDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insert(History history) {
        mongoTemplate.insert(history);
    }

    @Override
    public List<History> findAll() {
        return mongoTemplate.findAll(History.class);
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),History.class);
    }

    @Override
    public Long countValue() {
        GroupOperation group = Aggregation.group("action.type").sum("action.points").as("total");
        Aggregation agg = newAggregation(group);
        AggregationResults<Chips> history = mongoTemplate.aggregate(agg, "history", Chips.class);
        final Long[] result = {0L};
        history.forEach((chips) -> {
            if (chips.get_id().equals("ADD")) {
                result[0] +=chips.getTotal();
            } else {
                result[0] -= chips.getTotal();
            }
        });
        return result[0];
    }
}
