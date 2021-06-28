package br.com.zupcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupcar.model.Veiculo;
import br.com.zupcar.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;

	@GetMapping
	public List<Veiculo> ListarTodos() {
		return veiculoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
		return veiculoService.BuscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/usuario/{usuarioId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionarVeiculo(@PathVariable Long usuarioId, @RequestBody Veiculo veiculo) {
		return veiculoService.adicionar(veiculo, usuarioId);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		veiculoService.deletar(id);
	}
}
