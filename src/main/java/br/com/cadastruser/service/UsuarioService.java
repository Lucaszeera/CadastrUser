package br.com.cadastruser.service;

import java.util.List;

import br.com.cadastruser.models.Usuario;

public interface UsuarioService {
    public List<Usuario> getAllUsuarios();

    public Usuario getUsuarioById(Long id);

    public void insertUsuario(Usuario usuario);
}
