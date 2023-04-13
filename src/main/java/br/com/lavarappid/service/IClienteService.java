package br.com.lavarappid.service;

import java.util.List;

import br.com.lavarappid.dto.ClienteDto;
import br.com.lavarappid.model.Cliente;

public interface IClienteService {
	
	List<Cliente> listar();
	Cliente registrar(ClienteDto cliente);
	Cliente atualizar(ClienteDto cliente);
	void excluir(String cpf);
	Cliente listarPorCpf(String cpf);
	
}
