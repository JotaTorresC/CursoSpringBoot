package com.jason.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:values.properties")
})
public class ValuesConfig {
    hola mundo como estan? todo bien? esto es una prueba de escritura para ver si puedo escribir sin ver el monitor
}
