package com.db.account.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.account.model.Account;
import com.db.account.service.AccountService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/accounts")
@RestController
public class AccountsController {

    private final AccountService accountService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity<List<Account>> getAccounts() {
        // TODO: Remove hardcoded
        var accounts = accountService.getAccounts(1);
        return ResponseEntity.ok(accounts);
    }

}
