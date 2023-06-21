package com.db.account.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.db.account.dao.AccountDAO;
import com.db.account.model.Account;
import com.db.account.model.dto.AccountDTO;
import com.db.account.model.Transaction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountDAO dao;

    public List<Account> getAccounts(int customerId) {
        return dao.getAccounts(customerId);
    }
    
    public List<Account> addAccount(AccountDTO account) {
        dao.addAccount(account);
        return dao.getAccounts(account.getCustomerId());
    }
    
    public List<Transaction> getTransactions(int accountId) {
        return dao.getTransactions(accountId);
    }

    public List<Transaction> getTransactionsPeriod(int accountId, Date from, Date to) {
        return dao.getTransactionsPeriod(
            accountId,
            new Timestamp(from.getTime()),
            new Timestamp(to.getTime())
        );
    }
    
}
