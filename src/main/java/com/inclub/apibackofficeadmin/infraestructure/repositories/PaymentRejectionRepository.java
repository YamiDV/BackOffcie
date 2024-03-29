package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.inclub.apibackofficeadmin.domain.models.Reason.PaymentRejection;

public interface PaymentRejectionRepository extends ReactiveCrudRepository<PaymentRejection, Integer>{

}
