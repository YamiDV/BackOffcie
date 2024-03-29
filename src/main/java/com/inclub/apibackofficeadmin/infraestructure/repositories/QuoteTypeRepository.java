package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.inclub.apibackofficeadmin.domain.models.Reason.QuoteType;

public interface QuoteTypeRepository extends ReactiveCrudRepository<QuoteType, Integer>{

}
