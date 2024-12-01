package com.bank.accounts.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class Accountsdto {


    private String accountType;

    private Long accountNumber;

    private String branchAddress;

}
