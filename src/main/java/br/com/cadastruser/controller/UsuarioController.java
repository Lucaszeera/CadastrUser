package br.com.cadastruser.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastruser.exceptions.RestNotFoundException;
import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.repository.UsuarioRepository; 
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cadastruser")
public class UsuarioController{

    Logger logger = LoggerFactory.getLogger(Usuario.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAll(){
        logger.info("Mostrando todos os usuarios");

        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        logger.info("Mostrando um usuario");

        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario){
        logger.info("Cadastrando um usuario");

        usuarioRepository.save(usuario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        logger.info("Atualizando um usuario");

        usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        usuario.setId(id);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        logger.info("Deletando um usuario");

        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        usuarioRepository.delete(usuario);

        return ResponseEntity.noContent().build();
    }
}
