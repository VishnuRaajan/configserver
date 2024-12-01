package com.bank.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
public class Accounts extends BaseEntity{

    @Column(name = "customer_id" )
    private Long customerId;

    @Column(name = "account_type")
    private String accountType;

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "branch_address")
    private String branchAddress;

}
