package br.com.lavarappid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lavarappid.dto.ClienteDto;
import br.com.lavarappid.model.Cliente;
import br.com.lavarappid.repository.IClienteRepository;
import br.com.lavarappid.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteRepository repo;
	
	private Cliente parseCliente(ClienteDto clienteDto) {

		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDto.getCpf());
		cliente.setNome(clienteDto.getNome());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setTelefone(clienteDto.getTelefone());
		
		return cliente;
	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public Cliente registrar(ClienteDto clienteDTO) {
		Cliente cliente = parseCliente(clienteDTO);
		return repo.save(cliente);
	}

	@Override
	public Cliente atualizar(ClienteDto clienteDTO) {
		Cliente cliente = parseCliente(clienteDTO);
		return repo.save(cliente);
	}

	@Override
	public void excluir(String cpf) {
		repo.deleteById(cpf);	
	}

	@Override
	public Cliente listarPorCpf(String cpf) {
		return repo.findById(cpf).orElse(null);
	}

}
