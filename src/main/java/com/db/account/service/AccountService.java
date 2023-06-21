package com.db.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.db.account.model.Account;
import com.db.account.model.AccountDTO;
import com.db.account.model.Transaction;

@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbc;

    public List<Account> getAccounts(int customerId) {
        var res = jdbc.query(
            "SELECT id, customer_id, account_name, balance FROM accounts WHERE customer_id = ?", 
            (rs, rowNum) -> new Account(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getBigDecimal("balance"),
                rs.getString("account_name")
            ),
            customerId
        );

        return res;
    }
    
    /**
     * @param account
     * @return
     */
    public List<Account> addAccount(AccountDTO account) {
        jdbc.update("INSERT INTO accounts (customer_id, account_name, balance) VALUES (?, ?, ?)", account.getCustomerId(), account.getAccountName(), 0);

        // TODO: Throw error if update failed

        return jdbc.query(
            "SELECT id, customer_id, account_name, balance FROM accounts WHERE customer_id = ? AND account_name = ?", 
            (rs, rowNum) -> new Account(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getBigDecimal("balance"),
                rs.getString("account_name")
            ),
            account.getCustomerId(),
            account.getAccountName()
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
    
}
