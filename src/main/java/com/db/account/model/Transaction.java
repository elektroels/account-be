package com.db.account.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private int id, accountId;
    private BigDecimal amount;
    private LocalDateTime timeof;
}
