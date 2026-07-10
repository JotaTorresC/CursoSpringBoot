package com.jason.curso.springboot.webapp.springboot_web.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //en este caso estamos ingresando a la vista list cuando ingresamos localHost:8080 y se logra porque tenemos entre las rutas
    // las comillas vacias "" o con el / le podemos dar la ruta que queramos esta es como la base
    @GetMapping({"", "/", "home"})//con llaves para darle varias rutas
    public String home() {

        return "redirect:/list";
        //return "forward:/list";
    }
}
