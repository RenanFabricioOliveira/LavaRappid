package br.com.lavarappid.service;

import java.util.List;

import br.com.lavarappid.dto.ServicoDto;
import br.com.lavarappid.model.Servico;

public interface IServicoService {
	
	List<Servico> listar();
	Servico registrar(ServicoDto Servico);
	Servico atualizar(Servico Servico);
	Servico excluir(Integer id);
	Servico listarPorId(Integer id);

}
