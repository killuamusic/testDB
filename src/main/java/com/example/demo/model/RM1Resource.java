package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "RM1_RESOURCE")
public class RM1Resource {

    @Id
    @Column(name = "RESOURCE_TYPE_KEY")
    private int typeKey;

    @Column(name = "RESOURCE_VALUE")
    private String ResourceValue;

    @Column(name = "RESOURCE_POOL_ID")
    private int ResourcePoolId;

    @Column(name = "RESOURCE_STATUS")
    private String Status;

    @Column(name = "LAST_ACTIVITY_NAME")
    private String LastActivityName;

    @Column(name = "LAST_ACTIVITY_DATE")
    private Timestamp LastActivityDate;

    @Column(name = "CATEGORY_INDEX")
    private int CategoryIndex;

    @Column(name = "RESOURCE_PARENT_VALUE")
    private String sim;

}
