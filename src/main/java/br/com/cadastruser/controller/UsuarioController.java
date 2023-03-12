package br.com.cadastruser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private UsuarioService userService;

    public UsuarioController(UsuarioService usuarioService) {
        this.userService = usuarioService;
    }

    @GetMapping("/mostrar-todos")
    public List<Usuario> mostrarTodos(){
        return userService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario mostrarUsuario(@PathVariable Long id){
        return userService.getUsuarioById(id);
    }
    
    @PostMapping
    public void cadastrarUsuario(@RequestBody Usuario usuario){
        userService.insertUsuario(usuario);
    }

    @PutMapping("/{id}")
    public void atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario.setId(id);
        userService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        userService.excluirUsuario(id);
    }
}
