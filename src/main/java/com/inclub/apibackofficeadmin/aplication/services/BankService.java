package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.domain.models.Bank;

import reactor.core.publisher.Flux;

public interface BankService {

    public Flux<Bank> findAllBanks();

    
}
