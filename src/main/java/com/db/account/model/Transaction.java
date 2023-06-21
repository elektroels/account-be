package com.db.account.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Transaction {

    @Getter
    @Setter
    private int id, accountId;
    
    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    private LocalDateTime timeof;
}
