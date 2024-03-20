package com.inclub.apibackofficeadmin.domain.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class ItemMenu {
    
    @Getter
    @Setter
    @Id
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private int idMenu;

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column("createdate")
    private LocalDateTime createDate;

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column("updatedate")
    private int updateDate;

    public ItemMenu() {
    }

    public ItemMenu(String name, String url) {

        this.name = name;
        this.url = url;
        
    }

}
