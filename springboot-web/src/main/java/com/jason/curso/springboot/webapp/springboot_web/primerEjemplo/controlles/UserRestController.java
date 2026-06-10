package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.dto.UserDto;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model.User;

//Jjason apiRest
@RestController
@RequestMapping("/api")
public class UserRestController {

    public List<User> list() {
        User user1 = new User("Jason", "Torres");
        User user2 = new User("Vanessa", "Posada");
        User user3= new User(" Natalia", "Torres");

        List<User> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);

        return listaUsuarios;
    }

    @GetMapping("/detalleDto")
    public UserDto detalle(){
        UserDto usuarioDto1 = new UserDto();
        usuarioDto1.setTituloPagina("Hola Mundo Sping Boot");
        User Usuario1 = new User("Vanessa", "Posada");
        usuarioDto1.setUser(Usuario1);

        return usuarioDto1;
    }


    
    @GetMapping("/detalleMap")
    public Map<String, Object> detalleMap() {

        User user = new User("Jason", "Torres");
        Map<String, Object> cuerpoRespuesta = new HashMap<>();
        
        cuerpoRespuesta.put("titulo", "Hola Mundo Spring boot");
        cuerpoRespuesta.put("user", user);

        return cuerpoRespuesta;
    }
}