package com.idat.apirest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/publico")
    public String publico() {
        return "Bienvenido = Accesible para cualquier usuario, autenticado o anónimo.";
    }

    @GetMapping("/interno")
    public String interno(Authentication authentication) {
        return "Bienvenido = Accesible para cualquier usuario registrado en la base de datos , " + authentication.getName();
    }
  
    @GetMapping("/admin/gestion")
    public String admin() {
        return "Bienvenido = Accesible ÚNICAMENTE para usuarios con el rol ROLE_ADMIN";
    }
}
