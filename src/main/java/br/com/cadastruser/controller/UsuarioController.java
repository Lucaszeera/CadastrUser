package br.com.cadastruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @GetMapping("/mostrar")
    public String mostrarAlgo(){
        return "mostrando que rodou";
    }
}
