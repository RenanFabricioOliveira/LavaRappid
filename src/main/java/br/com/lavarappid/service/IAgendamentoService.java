package br.com.lavarappid.service;

import java.util.List;

import br.com.lavarappid.dto.AgendamentoDto;
import br.com.lavarappid.model.Agendamento;

public interface IAgendamentoService {

	List<Agendamento> listar();
	Agendamento registrar(AgendamentoDto agendamento);
	Agendamento atualizar(Agendamento agendamento);
	Agendamento excluir(int id);
	Agendamento listarPorId(int id);
	
}
