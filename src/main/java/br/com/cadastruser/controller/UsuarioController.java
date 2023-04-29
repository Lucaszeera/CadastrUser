package br.com.cadastruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastruser.exceptions.RestNotFoundException;
import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.repository.UsuarioRepository;
import br.com.cadastruser.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/cadastruser")
public class UsuarioController{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public Page<Usuario> getAll(@RequestParam(required = false) String cpf, @PageableDefault(size = 5) Pageable pageable){
        log.info("Mostrando todos os usuarios");
        if ( cpf == null ) return usuarioRepository.findAll(pageable);

        return usuarioRepository.findByCpfContaining(cpf, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        log.info("Mostrando um usuario");

        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario){
        log.info("Cadastrando um usuario");

        usuarioRepository.save(usuario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("Atualizando um usuario");

        usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        usuario.setId(id);
        
        if(usuarioService.salvarUsuario(usuario) == false) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        log.info("Deletando um usuario");

        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado."));

        usuarioRepository.delete(usuario);

        return ResponseEntity.noContent().build();
    }
}
