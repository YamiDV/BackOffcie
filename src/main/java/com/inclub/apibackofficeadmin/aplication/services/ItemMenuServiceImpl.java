package com.inclub.apibackofficeadmin.aplication.services;

import com.inclub.apibackofficeadmin.aplication.services.Interface.ItemMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import com.inclub.apibackofficeadmin.domain.models.ItemMenu;
import com.inclub.apibackofficeadmin.infraestructure.repositories.ItemMenuRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ItemMenuServiceImpl implements ItemMenuService {

    @Autowired
    private ItemMenuRepository itemMenuRepository;

    @Override
    public Flux<ItemMenu> findAllItemMenu() {
       return itemMenuRepository.findAll();
    }

    @Override
    public Mono<ItemMenu> findItemMenuById(int id) {
       return itemMenuRepository.findById(id);
    }

    @Override
    public Mono<ItemMenu> saveItemMenu(ItemMenu itemMenu) {
       return itemMenuRepository.save(itemMenu);
       
    }

    @Override
    public Mono<Void> delete(ItemMenu itemMenu) {
        return itemMenuRepository.delete(itemMenu);
    }
    
}
