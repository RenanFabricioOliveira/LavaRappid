package br.com.lavarappid.service;

import java.util.List;

import br.com.lavarappid.dto.VeiculoDto;
import br.com.lavarappid.model.Veiculo;

public interface IVeiculoService {

	List<Veiculo> listar();
	Veiculo registrar(VeiculoDto veiculoDto);
	Veiculo atualizar(Veiculo veiculo);
	void excluir(String placa);
	Veiculo listarPorPlaca(String placa);
}
