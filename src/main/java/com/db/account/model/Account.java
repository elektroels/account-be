package com.db.account.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private int id, customerId;
    private BigDecimal balance;
    private String accountName;
}
