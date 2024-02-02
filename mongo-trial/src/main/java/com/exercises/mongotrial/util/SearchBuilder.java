package com.exercises.mongotrial.util;

import com.exercises.mongotrial.collection.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchBuilder {

    private Query currentQuery = null;
    private List<Criteria> currentCriterias = null;
    private MongoTemplate mongoTemplate = null;
    private Class<?> entityClass;
    private Pageable pageable;

    private SearchBuilder(){

    }

    public <T> SearchBuilder(Pageable pageable, MongoTemplate mongoTemplate, Class<T> entityClass) {
        this.pageable = pageable;
        this.currentQuery = new Query().with(pageable);
        this.currentCriterias = new ArrayList<>();
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }

    public SearchBuilder addIsCriteria(SearchField queryField, Object value) {
        if (!ObjectUtils.isEmpty(value)) {
            this.currentCriterias.add(Criteria.where(queryField.fieldName()).is(value.toString()));
        }

        return this;
    }

    public SearchBuilder addCaseInsensitiveCriteria(SearchField queryField, Object value) {
        if (!ObjectUtils.isEmpty(value)) {
            this.currentCriterias.add(Criteria.where(queryField.fieldName()).regex(value.toString(), "i"));
        }

        return this;
    }

    public SearchBuilder addBetweenClosedIntervalCriteria(SearchField queryField, Object minValue, Object maxValue) {
        if (!ObjectUtils.isEmpty(minValue) && !ObjectUtils.isEmpty(maxValue)) {
            this.currentCriterias.add(Criteria.where(queryField.fieldName()).gte(minValue).lte(maxValue));
        }

        return this;
    }

    private void applyCriterias() {

        if (!currentCriterias.isEmpty()) {
            currentQuery.addCriteria(new Criteria()
                    .andOperator(currentCriterias.toArray(new Criteria[0])));
        }

    }

    public Page<?> getResults() {

        this.applyCriterias();

        Page<?> result = PageableExecutionUtils.getPage(
                mongoTemplate.find(currentQuery, entityClass),
                pageable,
                () -> mongoTemplate.count(currentQuery.skip(0).limit(0), entityClass)
        );

        return result;
    }

}
