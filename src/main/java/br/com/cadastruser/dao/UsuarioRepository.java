package br.com.cadastruser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import br.com.cadastruser.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public List<Usuario> getAll();

    public Usuario findById(Long id);

    public void save(Usuario usuario);
    
    public void delete(Long id);
}
