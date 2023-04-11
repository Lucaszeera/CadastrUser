package br.com.cadastruser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastruser.models.Usuario;
import br.com.cadastruser.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    Logger logger = LoggerFactory.getLogger(Usuario.class);

    public boolean salvarUsuario(Usuario usuario){
        return validarSenha(usuario);
    }

    public boolean validarSenha(Usuario usuario){
        String senhaCorreta = usuarioRepository.findById(usuario.getId()).get().getSenha();
        if(senhaCorreta.equals(usuario.getSenha())){
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
}
