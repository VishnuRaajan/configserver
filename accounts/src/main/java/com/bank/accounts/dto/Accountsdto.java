package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@Schema(name = "Accounts",description = "Account details")
public class Accountsdto {


    @NotEmpty(message = "account type should not be empty")
    @Schema(description = "Account type",example = "Savings")
    private String accountType;


    @NotEmpty(message = "account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message="account number should be 10 digits")
    @Schema(description = "Account number",example = "1234567890")
    private Long accountNumber;

    @Schema(description = "Branch address",example = "123 Main Street, New York")
    @NotEmpty(message = "branch address should not be empty")
    private String branchAddress;

}
