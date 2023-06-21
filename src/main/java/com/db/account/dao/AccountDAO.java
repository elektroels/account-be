package com.db.account.dao;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.db.account.model.Account;
import com.db.account.model.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import com.db.account.model.Transaction;

@RequiredArgsConstructor
@Service
public class AccountDAO {
    private final JdbcTemplate jdbc;

    public List<Account> getAccounts(int customerId) {
        return jdbc.query(
            "SELECT id, customer_id, account_name, balance FROM accounts WHERE customer_id = ?", 
            (rs, rowNum) -> new Account(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getBigDecimal("balance"),
                rs.getString("account_name")
            ),
            customerId
        );
    }
   
    public int addAccount(AccountDTO account) {
        return jdbc.update(
            "INSERT INTO accounts (customer_id, account_name, balance) VALUES (?, ?, ?)",
            account.getCustomerId(),
            account.getAccountName(),
            0
        );
    }

    public List<Transaction> getTransactions(int accountId) {
        return jdbc.query(
            "SELECT id, account_id, amount, timeof FROM transactions WHERE account_id = ?", 
            (rs, rowNum) -> new Transaction(
                rs.getInt("id"),
                rs.getInt("account_id"),
                rs.getBigDecimal("amount"),
                rs.getTimestamp("timeof").toLocalDateTime()
            ),
            accountId
        );
    }

    public List<Transaction> getTransactionsPeriod(int accountId, Timestamp from, Timestamp to) {
        return jdbc.query(
            "SELECT id, account_id, amount, timeof FROM transactions WHERE account_id = ? AND timeof > ? AND timeof < ?", 
            (rs, rowNum) -> new Transaction(
                rs.getInt("id"),
                rs.getInt("account_id"),
                rs.getBigDecimal("amount"),
                rs.getTimestamp("timeof").toLocalDateTime()
            ),
            accountId,
            from,
            to
        );
    }
    
}
