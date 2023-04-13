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

import br.com.lavarappid.dto.AgendamentoDto;
import br.com.lavarappid.model.Agendamento;
import br.com.lavarappid.service.IAgendamentoService;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin("http://localhost:4200")
public class AgendamentoController {

	@Autowired
	IAgendamentoService service;

	@GetMapping
	public ResponseEntity <List <Agendamento>> listar() {
		List<Agendamento> list = service.listar();
		return new ResponseEntity<List<Agendamento>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity <Agendamento> registrar(@RequestBody AgendamentoDto agendamentoDto) throws Exception {
		Agendamento a = service.registrar(agendamentoDto);
		if (a.getIdAgendamento() == 0) {
			return new ResponseEntity<Agendamento>(a, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Agendamento>(a, HttpStatus.OK);
		}
	}

	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<Agendamento> listarPorId(@PathVariable ("id")int id) throws Exception{ 
		Agendamento a = service.listarPorId(id); 
		if(a == null){ 
			throw new Exception("Id não encontrado!"); 
		}
		return new ResponseEntity<Agendamento>(a, HttpStatus.OK); 
	}

	@PutMapping(path = {"/{id}"})
	public Agendamento atualizar(@RequestBody Agendamento agendamento, @PathVariable("id") int id){
		agendamento.setIdAgendamento(id);
		return service.atualizar(agendamento);
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluir(@PathVariable ("id") int id) throws Exception{ 
		Agendamento a = service.listarPorId(id); 
		if(a == null){ 
			throw new Exception("Id não encontrado!"); 
		} 
		service.excluir(id); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
