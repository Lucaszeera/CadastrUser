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
            new Usuario(1L, "Lucas Costa", 19, "08101054484", "11973455655", "lucas.hbrd@gmail.com", "1928")
        ));
    }


}
