package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boba")
public class Controller {
    private final AccountService accountService;

    @Autowired
    public Controller(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/first")
    public String first() {
        return "Hello Vova Volkodav!";
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody AccountDto toCreate) {
        return accountService.save(toCreate);
    }

    @PostMapping("/update/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody AccountDto update) {
        return accountService.update(id, update);
    }
}