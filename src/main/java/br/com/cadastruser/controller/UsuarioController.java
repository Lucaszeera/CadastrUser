package br.com.cadastruser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.service.UsuarioService;

@RestController
public class UsuarioController{

    private UsuarioService userService;

    public UsuarioController(UsuarioService usuarioService) {
        this.userService = usuarioService;
    }

    @GetMapping("/mostrar")
    public List<Usuario> mostrarAlgo(){
        return userService.getAllUsuarios();
    }
}
