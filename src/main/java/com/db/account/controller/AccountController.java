package com.db.account.controller;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.db.account.model.Account;
import com.db.account.model.dto.AccountDTO;
import com.db.account.model.Transaction;
import com.db.account.service.AccountService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("")
    public ResponseEntity<List<Account>> addAccount(@RequestBody AccountDTO account) {
        var accounts = accountService.addAccount(account);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getAccountTransactions(
        @PathVariable("accountId")  int accountId,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date to
    ) {
        if (from != null && to != null) {
            var transactions = accountService.getTransactionsPeriod(accountId, from, to);
            return ResponseEntity.ok(transactions);
        }

        var transactions = accountService.getTransactions(accountId);
        return ResponseEntity.ok(transactions);
    }

}
