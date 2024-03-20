package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.services.Interface.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import com.inclub.apibackofficeadmin.domain.models.Menu;
import com.inclub.apibackofficeadmin.infraestructure.repositories.MenuRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Flux<Menu> findAllMenu() {
        return menuRepository.findAll(); 
    }

    @Override
    public Mono<Menu> findMenuById(int id) {
        return menuRepository.findById(id);
    }

    @Override
    public Mono<Menu> saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Mono<Void> delete(Menu menu) {
        return menuRepository.delete(menu);
    }

    
}
