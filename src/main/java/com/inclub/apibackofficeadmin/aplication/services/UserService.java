package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    public Flux<User> findAllUsers();

    public Mono<User> findUserById(int id);
    
    public Mono<User> saveUser(User user);
    
   
    public Mono<Void> delete(User user);

    

    
    
}
