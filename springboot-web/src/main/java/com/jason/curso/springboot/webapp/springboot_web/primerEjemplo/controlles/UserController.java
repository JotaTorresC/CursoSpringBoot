package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

//thymeleaf html
@Controller
public class UserController {

    //estos dos metodos son lo mismo solo que uno es usando Model
    //y el otro usando Mapas
    @GetMapping("/detalle")
    public String detalle(Model model) {

        User user = new User("Natalia", "Torres", "Natalia@Gmail");

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

    ////////////////////////////////////////////////////////////////////////////////////////

    //asi podemos usar una especie de datos quedamos que querramos reutilizar con el @ModelAttribute()
    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado De Usuarios!");
        return "list";
    }

    @ModelAttribute("listaUsuarios")
    public List<User> userModel() {
        List<User> listaUsuarios = Arrays.asList(
                new User("pepa", "gonzales"),
                new User("jota", "ramirez", "jota@gmail"),
                new User("ursula", "perez"),
                new User("lalo", "roe", "lalo@gmail"));

        return listaUsuarios;
    }

    ////////////////////////////////////////////////////////////////////////////////////
}

