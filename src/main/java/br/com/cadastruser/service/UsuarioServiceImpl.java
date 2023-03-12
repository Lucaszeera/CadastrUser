package br.com.cadastruser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastruser.dao.UsuarioRepository;
import br.com.cadastruser.models.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.getById(id);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id){
        usuarioRepository.delete(id);
    }

}