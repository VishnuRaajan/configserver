package com.bank.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

}
