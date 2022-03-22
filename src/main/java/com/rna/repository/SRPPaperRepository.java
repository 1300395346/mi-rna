package com.rna.repository;

import com.rna.entity.SRPPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * @Classname SRPPaperRepository
 * @Description SRP-论文表的操作类
 * @Date 2022/3/22 16:07
 * @Created by TaoVh
 */
@Repository
public class SRPPaperRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean save(SRPPaper srpPaper){
        if (srpPaper==null) return false;
        mongoTemplate.save(srpPaper, "SRPPaper");
        return true;
    }

    public SRPPaper findBySRP(String SRP){
        Query query = new Query(Criteria.where("SRP").is(SRP));
        return mongoTemplate.findOne(query,SRPPaper.class);
    }
}
