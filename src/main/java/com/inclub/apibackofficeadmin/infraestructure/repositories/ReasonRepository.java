package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.inclub.apibackofficeadmin.domain.models.Reason.Reason;

public interface ReasonRepository extends ReactiveCrudRepository <Reason, Integer>{

}
