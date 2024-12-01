package com.bank.accounts.dto;

import lombok.*;

@Data @AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMsg;
}
