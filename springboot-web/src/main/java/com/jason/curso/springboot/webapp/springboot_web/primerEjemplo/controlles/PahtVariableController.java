package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.dto.ParamDto;
import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PahtVariableController {

//    @Value("${config.code}")
//    private Integer code;

    @Value("${config.userName}")
    private String userName;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValue}")
    private String[] listOfValue;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPahtVar(@PathVariable String product,@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        //hacer algo con el usuario ejemplo un save en la base de datos
        user.setNombre(user.getNombre().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.code}") Integer code) {
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("userName", userName);
        json.put("message", message);
        json.put("listOfValue", listOfValue);

        return json;
    }

}
