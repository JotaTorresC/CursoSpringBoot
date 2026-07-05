package com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.controlles;

import com.jason.curso.springboot.webapp.springboot_web.primerEjemplo.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "hola esta pagina esta vacia") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        Integer code= 0;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }

        ParamDto params = new ParamDto();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }
}
