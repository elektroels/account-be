package com.db.account.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.account.dao.AccountDAO;
import com.db.account.model.Account;
import com.db.account.model.dto.AccountDTO;
import com.db.account.model.Transaction;

@Service
public class AccountService {
    @Autowired
    AccountDAO dao;

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
    
}
