package br.com.zupcar.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zupcar.model.Fipe;
import br.com.zupcar.model.Modelos;

@Service
@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeService {

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas")
	List<Fipe> getMarcas();

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{id}/modelos")
	Modelos getMarcaPorId(@PathVariable("id") String id);

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{marcasId}/modelos/{modeloId}/anos")
	List<Fipe> getModeloPorId(@PathVariable("marcasId") String marcasId, @PathVariable("modeloId") String modeloId);

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{marcasId}/modelos/{modeloId}/anos/{anoId}")
	Map<String, String> getAnoPorId(@PathVariable("marcasId") String marcasId, @PathVariable("modeloId") String modeloId, 
			@PathVariable("anoId") String anoId);

}
