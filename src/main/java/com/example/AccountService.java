package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final Repository repository;
    @Autowired
    public AccountService(Repository repository) {
        this.repository = repository;
    }

    public Account save(AccountDto toCreate) {
        return repository.save(new Account(toCreate.getName(), toCreate.getSurname()));
    }

    public Account update(Long id, AccountDto update) {
        Account byId = repository.findById(id).get();
        byId.setName(update.getName());
        byId.setSurname(update.getSurname());
        repository.save(byId);
        return byId;
    }
}
