package com.db.account.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.db.account.model.Account;
import com.db.account.service.AccountService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountsController {

    private final AccountService accountService;

    @GetMapping("/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable("customerId")  int customerId) {
        var accounts = accountService.getAccounts(customerId);
        return ResponseEntity.ok(accounts);
    }

}
