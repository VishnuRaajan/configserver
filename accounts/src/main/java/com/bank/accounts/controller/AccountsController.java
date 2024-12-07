package com.bank.accounts.controller;

import com.bank.accounts.constants.*;
import com.bank.accounts.dto.*;
import com.bank.accounts.entity.*;
import com.bank.accounts.service.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "CRUD operation for Accounts", description = "Accounts Controller")
public class AccountsController {

    private IAccountService iAccountService;

    @Operation(summary = "Say Hello")
    @GetMapping("/sayHello")
    public String sayHello()
    {
        return "Welcome to the Bank ...";
    }

    @Operation(summary = "Create Customer",description = "Rest api to create customer in the bank")
    @ApiResponse(responseCode = "201",description = "Customer created successfully")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody @Valid CustomerDto customerDto)
    {
        iAccountService.create(customerDto);

        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                  @Pattern(regexp = "(^$|[0-9]{10})",message="mobile number should be 10 digits")
                  String mobileNumber)
    {
        CustomerDto customerDto = iAccountService.getCustomerAndAccounts(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @PutMapping("/update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Account updated successfully"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error"
            ,content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody @Valid CustomerDto customerDto)
    {
        boolean isUpdated = iAccountService.updateCustomerAndAccount(customerDto);
        if(isUpdated)
        {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                           @Pattern(regexp = "(^$|[0-9]{10})",message="mobile number should be 10 digits")
                           String mobileNumber)
    {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
        if(isDeleted)
        {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
        }
    }
}
