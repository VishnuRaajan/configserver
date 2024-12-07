package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@Schema(name = "Customer",description = "Customer details")
public class CustomerDto {

    @Schema(description = "name of the customer",example = "John Doe",required = true)
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5,max = 30,message = "name should be between 5 to 30 characters")
    private String name;

    @Schema(description = "mobile number of the customer",example = "9876543210",required = true)
    @Pattern(regexp = "(^$|[0-9]{10})",message="mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(description = "email of the customer",example = "8dY6l@example.com",required = true)
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    private String email;

    @Schema(description = "account details of the customer",required = true)
    private Accountsdto accountsdto;
}
