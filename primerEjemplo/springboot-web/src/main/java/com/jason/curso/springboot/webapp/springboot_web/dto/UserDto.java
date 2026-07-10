package com.jason.curso.springboot.webapp.springboot_web.dto;

import com.jason.curso.springboot.webapp.springboot_web.model.User;

public class UserDto {
    private String TituloPagina;
    private User user;

    public String getTituloPagina() {
        return TituloPagina;
    }

    public void setTituloPagina(String tituloPagina) {
        TituloPagina = tituloPagina;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
