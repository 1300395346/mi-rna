package com.rna.repository.interfaces;

import com.rna.entity.SRP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SRPRepository extends MongoRepository<SRP,String> {
    public SRP findBysrpName(String srpName);
}
