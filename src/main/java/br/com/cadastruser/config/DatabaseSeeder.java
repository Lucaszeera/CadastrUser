package br.com.cadastruser.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.saveAll(List.of(
            new Usuario(1L, "Lucas", 20, "1222000", "973452", "lucas.hbrd@gmail.com", "0000"),
            new Usuario(2L, "Ariosvaldo", 40, "11667000", "9721334", "ari@gmail.com", "ari0000")
        ));
    };


}
