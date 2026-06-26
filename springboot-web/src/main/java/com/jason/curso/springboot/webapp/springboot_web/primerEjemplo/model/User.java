package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nombre", "apellido", "email"})
public class User {

    private String nombre;
    private String apellido;
    private String email;

    public User(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public User(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public User(){
        
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
