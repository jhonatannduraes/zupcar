package br.com.zupcar.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zupcar.controller.FipeController;
import br.com.zupcar.model.Fipe;
import br.com.zupcar.model.Modelos;
import br.com.zupcar.model.Usuario;
import br.com.zupcar.model.Veiculo;
import br.com.zupcar.repository.UsuarioRepository;
import br.com.zupcar.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	FipeController fipeController;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	public Optional<Veiculo> BuscarPorId(Long id) {
		return veiculoRepository.findById(id);
	}

	public Veiculo retornaValor(Veiculo veiculo) {

		Fipe fipe = new Fipe();

		List<Fipe> list = fipeController.getMarcas();
		for (Fipe f : list) {
			if (f.getNome().equals(veiculo.getMarca())) {
				fipe.setMarca(f.getCodigo());
			}
		}

		Modelos listarMarcasPorId = fipeController.getMarcaPorId(fipe.getMarca());
		Fipe[] listarModelos = listarMarcasPorId.getModelos();
		for (Fipe f : listarModelos) {
			if (f.getNome().equals(veiculo.getModelo())) {
				fipe.setModelo(f.getCodigo());
			}
		}

		List<Fipe> listarModelosPorId = fipeController.getModeloPorId(fipe.getMarca(), fipe.getModelo());
		for (Fipe l : listarModelosPorId) {
			if (l.getCodigo().equals(veiculo.getAno())) {
				fipe.setAno(l.getCodigo());
			}
		}

		Map<String, String> result = fipeController.getAnoPorId(fipe.getMarca(), fipe.getModelo(), fipe.getAno());
		fipe.setValor(result.get("Valor"));
		veiculo.setValor(fipe.getValor());

		Veiculo veiculoAtualizado = new Veiculo();
		veiculoAtualizado.setAno(veiculo.getAno());
		veiculoAtualizado.setMarca(veiculo.getMarca());
		veiculoAtualizado.setModelo(veiculo.getModelo());
		veiculoAtualizado.setRodizioAtivo(veiculo.getRodizioAtivo());
		veiculoAtualizado.setValor(veiculo.getValor());

		return veiculoAtualizado;
	}

	public Veiculo adicionar(Veiculo veiculo, Long usuarioId) {
		Usuario usuario = usuarioRepository.getById(usuarioId);
		veiculo = retornaValor(veiculo);
		veiculo.setUsuario(usuario);
		return veiculoRepository.save(veiculo);
	}

	public void deletar(Long id) {
		veiculoRepository.deleteById(id);
	}
}
