package com.example.surveyproject.security.services;

import com.example.surveyproject.models.SurveyResponseSequence;
import com.example.surveyproject.models.SurveySequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSurveySequence(String seqName) {

        SurveySequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                SurveySequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }

    public long generateSurveyResponseSequence(String seqName) {

        SurveyResponseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                SurveyResponseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}
