package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.dto.ParamDto;
import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    ////////////////////////////////////////////////////////////////////////////////////////
    //esta es la manera de colocar un String pero de manera manual
    @Value("#{'${config.listOfValues}'.toUpperCase}")
    private String valueString;
    ////////////////////////////////////////////////////////////////////////////////////////

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    ////////////////////////////////////////////////////////////////////////////////////////
    //esta es la manera de colocar una lista pero de manera manual
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;
    ////////////////////////////////////////////////////////////////////////////////////////

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment environment;

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

        Long code2 = environment.getProperty("config.code", Long.class);
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("userName", userName);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        // asi es como usando el environment se tranforma a un entero ya que el environment por defecto todo es string
        // o con el valuesOf()
        json.put("code2", code2);
        json.put("listOfValue", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }

}
