package br.com.lavarappid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lavarappid.dto.ServicoDto;
import br.com.lavarappid.model.Servico;
import br.com.lavarappid.service.IServicoService;

@RestController
@RequestMapping("/servicos")
@CrossOrigin("http://localhost:4200")
public class ServicoController {
	
	@Autowired
	private IServicoService service;
	
	@GetMapping
	public List<Servico> listar(){
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Servico> registrar(@RequestBody ServicoDto servicoDto) {
		Servico s = service.registrar(servicoDto);
		return new ResponseEntity<Servico>(s, HttpStatus.OK);
	}
	
	@PutMapping(path = {"/{id}"})
	public Servico atualizar(@RequestBody Servico servico, @PathVariable("id") int id) {
		servico.setIdServico(id);
		return service.atualizar(servico);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Servico excluir(@PathVariable ("id") int id) {
		return service.excluir(id);
	}
	
	@GetMapping(path = {"/{id}"})
	public Servico listarPorId(@PathVariable ("id") int id) {
		return service.listarPorId(id);
	}	

}








