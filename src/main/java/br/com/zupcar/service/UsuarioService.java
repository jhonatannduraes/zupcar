package br.com.zupcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.zupcar.exception.NegocioExcecption;
import br.com.zupcar.model.Usuario;
import br.com.zupcar.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(@PathVariable Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario adicionar(Usuario usuario) throws NegocioExcecption {
		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail()).isPresent();
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).isPresent();
		if (emailEmUso) {
			throw new NegocioExcecption("Já existe um cliente cadastrado com este e-mail.");
		} else if (cpfEmUso) {
			throw new NegocioExcecption("Já existe um cliente cadastrado com este cpf.");
		}

		return usuarioRepository.save(usuario);
	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
}
