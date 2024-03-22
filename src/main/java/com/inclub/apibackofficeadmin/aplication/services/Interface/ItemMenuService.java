package com.inclub.apibackofficeadmin.aplication.services.Interface;

import com.inclub.apibackofficeadmin.domain.models.ItemMenu;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemMenuService {

    public Flux<ItemMenu> findAllItemMenu();

    public Mono<ItemMenu> findItemMenuById(int id);

    public Mono<ItemMenu> saveItemMenu(ItemMenu itemMenu);
    
    public Mono<Void> delete(ItemMenu itemMenu);
    public Flux<ItemMenu> GetRolesByUser();


    

    
}
