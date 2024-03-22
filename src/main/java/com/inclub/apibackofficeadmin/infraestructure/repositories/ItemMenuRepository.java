package com.inclub.apibackofficeadmin.infraestructure.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.inclub.apibackofficeadmin.domain.models.ItemMenu;

import reactor.core.publisher.Flux;

@Repository
public interface ItemMenuRepository extends ReactiveCrudRepository<ItemMenu, Integer>{

    @Query("SELECT * FROM itemmenu  itm INNER JOIN userpermissionsitemmenu permiso ON permiso.iditemmenu = itm.id INNER JOIN users u ON u.id = permiso.iduser WHERE u.id = 2")
    public Flux<ItemMenu> GetRolesByUser();
    
}
