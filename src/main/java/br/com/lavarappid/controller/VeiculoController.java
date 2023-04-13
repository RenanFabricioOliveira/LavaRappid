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

import br.com.lavarappid.dto.VeiculoDto;
import br.com.lavarappid.model.Veiculo;
import br.com.lavarappid.service.IVeiculoService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("http://localhost:4200")
public class VeiculoController {

	
	@Autowired
	private IVeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listar(){
		List<Veiculo> list = service.listar();
		return new ResponseEntity<List<Veiculo>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> registrar(@RequestBody VeiculoDto veiculoDto){
		Veiculo v = service.registrar(veiculoDto);
		if (v.getCliente_cpf() == null) {
			return new ResponseEntity<Veiculo>(v, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Veiculo>(v, HttpStatus.OK);
		}
	}
	
	@PutMapping(path = {"/{id}"})
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable("id") String placa) {
		veiculo.setPlaca(placa);
		return service.atualizar(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable ("id") String placa) throws Exception {
		Veiculo v = service.listarPorPlaca(placa);
		if(v == null) {
			throw new Exception("Placa do veiculo não encontrada!");
		}
		service.excluir(placa);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> listaPorId(@PathVariable ("id") String placa) throws Exception {
		Veiculo v = service.listarPorPlaca(placa);
		if(v == null) {
			throw new Exception("Id não encontrado!");
		}
		return new ResponseEntity<Veiculo>(v, HttpStatus.OK);
	}
}























