package br.com.cadastruser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/mostrar")
    public String mostrarAlgo(){
        return "mostrando que rodou";
    }
}
