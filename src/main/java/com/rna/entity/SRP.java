package com.rna.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Data
/**
 * 一个项目包括多个SRR
 */
public class SRP {
    @Id
    public String id;

    public String srpName;
    public Integer srrAmount;
    public SRP(String srpName,Integer srrAmount){
        this.srpName = srpName;
        this.srrAmount = srrAmount;
    }
}
