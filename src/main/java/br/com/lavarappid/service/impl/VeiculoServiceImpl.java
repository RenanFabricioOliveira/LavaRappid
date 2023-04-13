package br.com.lavarappid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lavarappid.dto.VeiculoDto;
import br.com.lavarappid.model.Cliente;
import br.com.lavarappid.model.Veiculo;
import br.com.lavarappid.repository.IVeiculoRepository;
import br.com.lavarappid.service.IVeiculoService;

@Service
public class VeiculoServiceImpl implements IVeiculoService {
	
	@Autowired
	IVeiculoRepository repo;
	
	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	private Veiculo parseVeiculo(VeiculoDto veiculoDto) {

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(veiculoDto.getPlaca());
		veiculo.setModelo(veiculoDto.getModelo());
		veiculo.setPorte(veiculoDto.getPorte());
		veiculo.setCor(veiculoDto.getCor());
		
		Cliente cliente = new Cliente();
		cliente.setCpf(veiculoDto.getCliente_cpf());
		veiculo.setCliente_cpf(cliente);
		
		return veiculo;
	}
		
	@Override
	public List<Veiculo> listar() {
		return repo.findAll();
	}

	@Override
	public Veiculo registrar(VeiculoDto veiculoDto) {
		Cliente listarPorCpf = clienteServiceImpl.listarPorCpf(veiculoDto.getCliente_cpf());
		Veiculo retorno = new Veiculo();
		if(listarPorCpf != null) {
			retorno = repo.save(parseVeiculo(veiculoDto));
		}
		return retorno;
	}

	@Override
	public Veiculo atualizar(Veiculo veiculo) {
		return repo.save(veiculo);
	}

	@Override
	public void excluir(String placa) {
		repo.deleteById(placa);
	}

	@Override
	public Veiculo listarPorPlaca(String placa) {
		return repo.findById(placa).orElse(null);
	}
}
