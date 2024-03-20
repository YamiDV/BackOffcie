package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.Mapper.Interface.UserMapper;
import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.domain.models.User;
import com.inclub.apibackofficeadmin.infraestructure.repositories.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Flux<UserResponse> findAllUsers() {
        return userRepository.findAll().map(userMapper::convertToResponse);
    }

    @Override
    public Mono<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Mono<Void> delete(User user) {
        return userRepository.delete(user);
    }

    
    
}
