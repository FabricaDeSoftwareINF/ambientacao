package br.ufg.inf.onboarding.repository;

import br.ufg.inf.onboarding.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    Usuario findByCpf(String cpf);
}
