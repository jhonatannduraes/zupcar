package br.com.zupcar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupcar.model.Fipe;
import br.com.zupcar.model.Modelos;
import br.com.zupcar.service.FipeService;

@RestController
@RequestMapping("/fipe")
public class FipeController {

	@Autowired
	FipeService fipeService;

	@GetMapping
	public List<Fipe> getMarcas() {
		return fipeService.getMarcas();
	}

	@RequestMapping("/marcas/{marcasId}")
	public Modelos getMarcaPorId(@PathVariable String marcasId) {
		return fipeService.getMarcaPorId(marcasId);
	}
	
	@RequestMapping("/marcas/{marcasId}/modelos/{modeloId}")
	public List<Fipe> getModeloPorId(@PathVariable String marcasId, @PathVariable String modeloId) {
		return fipeService.getModeloPorId(marcasId, modeloId);
	}

	@RequestMapping("/marcas/{marcasId}/modelo/{modeloId}/ano/{anoId}")
	public Map<String, String> getAnoPorId(@PathVariable String marcasId, @PathVariable String modeloId, @PathVariable String anoId) {
		return fipeService.getAnoPorId(marcasId, modeloId, anoId);
	}

}
