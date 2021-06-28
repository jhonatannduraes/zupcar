package br.com.zupcar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupcar.model.Usuario;
import br.com.zupcar.model.Veiculo;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findById(Long id);
	Optional<Usuario> save(Optional<Usuario> usuario);
	Optional<Veiculo> save(Veiculo veiculo);

}
