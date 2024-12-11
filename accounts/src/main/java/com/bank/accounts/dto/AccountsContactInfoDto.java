package com.bank.accounts.dto;

import lombok.*;
import org.springframework.boot.context.properties.*;

import java.util.*;

@ConfigurationProperties(prefix = "accounts")
@Getter@Setter
public class AccountsContactInfoDto
{
    String message;
    Map<String, String> contactDetails;
    List<String> onCallSupport;

}
