package com.db.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {
    // konto har et navn, et id, en balance, nogen transaktioner
    // id "tilhører" en til flere brugere =:)

    @GetMapping("/balance")
    public ResponseEntity<String> getAccountBalance() {
        return ResponseEntity.ok("balance");
    }

    @GetMapping("/balance")
    public ResponseEntity<String> getAccountTransactions() {
        // Liste af trans
        return ResponseEntity.ok("balance");
    }

    // account/xyz/balance




}
