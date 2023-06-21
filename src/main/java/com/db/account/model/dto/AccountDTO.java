package com.db.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AccountDTO {

    @Getter
    @Setter
    private int customerId;
    
    @Getter
    @Setter
    private String accountName;
}
