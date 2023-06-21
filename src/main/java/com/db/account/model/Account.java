package com.db.account.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Account {

    @Getter
    @Setter
    private int id, customerId;
    
    @Getter
    @Setter
    private BigDecimal balance;
    
    @Getter
    @Setter
    private String accountName;
}
