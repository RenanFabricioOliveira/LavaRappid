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

import br.com.lavarappid.dto.ClienteDto;
import br.com.lavarappid.model.Cliente;
import br.com.lavarappid.service.IClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> list = service.listar();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity <Cliente> registrar(@RequestBody ClienteDto clienteDTO) {
		Cliente c = service.registrar(clienteDTO);
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}

	@PutMapping(path = { "/{id}" }) 
	public Cliente atualizar(@RequestBody ClienteDto clienteDTO, @PathVariable("id") String cpf) { 
		clienteDTO.setCpf(cpf); 
		return service.atualizar(clienteDTO); 
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluir(@PathVariable ("id") String cpf) throws Exception { 
		Cliente c = service.listarPorCpf(cpf); 
		if(c == null) { 
			throw new Exception("Id não encontrado!"); 
		} 
		service.excluir(cpf); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping ("/{id}") 
	public ResponseEntity<Cliente> listarPorId(@PathVariable ("id")String cpf) throws Exception{ 
		Cliente c = service.listarPorCpf(cpf); 
		if(c == null) { 
			throw new Exception("Cpf do cliente não encontrado!"); 
		} 
		return new ResponseEntity<Cliente> (c, HttpStatus.OK);
	}
}


