package br.com.lavarappid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lavarappid.dto.LavaRapidoDto;
import br.com.lavarappid.model.LavaRapido;
import br.com.lavarappid.service.ILavaRapidoService;

@RestController
@RequestMapping("/lavarapido")
@CrossOrigin("http://localhost:4200")
public class LavaRapidoController {

	@Autowired
	private ILavaRapidoService service;

	@GetMapping
	public List<LavaRapido> listar() {
		return service.listar();
	}
	
	@GetMapping(path = {"/{id}"})
	public LavaRapido listarPorId(@PathVariable ("id") int id) {
		return service.listarPorId(id);
	}	

	@PostMapping
	public LavaRapido registrar(@RequestBody LavaRapidoDto lavaRapidoDto) {
		return service.registrar(lavaRapidoDto);
	}

	@PutMapping(path = { "/{id}" })
	public LavaRapido atualizar(@RequestBody LavaRapidoDto lavaRapidoDto, @PathVariable("id") int id) {
		lavaRapidoDto.setIdLavarapido(id);
		return service.atualizar(lavaRapidoDto);
	}

	@DeleteMapping(path = { "/{id}" })
	public LavaRapido excluir(@PathVariable("id") int id) {
		return service.excluir(id);
	}
}
