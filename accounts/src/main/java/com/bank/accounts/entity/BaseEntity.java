package com.bank.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@MappedSuperclass
@Getter@Setter@ToString
public class BaseEntity {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_date", insertable = false)
    private LocalDateTime updatedDate;

    @Column(name = "updated_by", insertable = false)
    private String updatedBy;

}
