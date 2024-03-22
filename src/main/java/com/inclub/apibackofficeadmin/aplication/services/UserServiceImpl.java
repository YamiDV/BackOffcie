package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.Mapper.Interface.UserMapper;
import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.Responses.Login.LoginResponse;
import com.inclub.apibackofficeadmin.domain.Responses.Login.UserResponse;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inclub.apibackofficeadmin.domain.models.User;
import com.inclub.apibackofficeadmin.infraestructure.repositories.UserRepository;
import com.inclub.apibackofficeadmin.security.JWTUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JWTUtil jwtUtil;

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

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }


    @Override
public Mono<LoginResponse> validateLogin(String username, String password) {
    return userRepository.findByUserName(username)
        .filter(user -> password.equals(user.getPassword()))
        .flatMap(user -> {
            String token = jwtUtil.generateToken(user);
            Date expiration = jwtUtil.getExpirationDateFromToken(token);
            return Mono.just(new LoginResponse(token, expiration));
        })
        .switchIfEmpty(Mono.empty());
}

    // @Override
    // public Mono<LoginResponse> validateLogin(String username, String password) {

       
    //      Mono<User> userLogin =  userRepository.findByUserName(username)
    //      .filter(user -> password.equals(user.getPassword()));

    

    //      if (userLogin != null) {
            
    //          String token = jwtUtil.generateToken(userLogin.block());

    //          Date expiration = jwtUtil.getExpirationDateFromToken(token);

    //          return Mono.just(new LoginResponse(token, expiration));

    //     }

    //     return Mono.empty();
        
                
    // }

    
    
}
