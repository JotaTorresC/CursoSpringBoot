package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model.User;

//thymeleaf html
@Controller
public class UserController {

    //estos dos metodos son lo mismo solo que uno es usando Model
    //y el otro usando Mapas
    @GetMapping("/detalle")
    public String detalle(Model model) {

        User user = new User("Natalia", "Torres");

        model.addAttribute("titulo", "Hola Mundo Spring boot");
        model.addAttribute("user", user);

        return "detalle";
    }

    /*  
    public String detalle(Map<String, Object> model) {
        model.put("titulo", "Hola Mundo Spring boot");
        model.put("nombre", "Jason");
        model.put("apellido", "Torres");

        return "detalle";
    }
    */
}

