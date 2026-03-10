package com.recarga.RecargaCredencial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/ivonne")
    public String ivonne() {
        return "Hola, soy Ivonne.<br>Integrante del equipo Feedback Amigo";
    }

    @GetMapping("/javier")
    public String javier() {
        return "Hola, soy Ivonne.<br>Integrante del equipo Feedback Amigo";
    }
}
