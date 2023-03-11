package br.com.cadastruser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastruser.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
