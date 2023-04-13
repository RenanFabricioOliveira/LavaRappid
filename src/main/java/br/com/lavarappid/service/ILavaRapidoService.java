package br.com.lavarappid.service;

import java.util.List;

import br.com.lavarappid.dto.LavaRapidoDto;
import br.com.lavarappid.model.LavaRapido;

public interface ILavaRapidoService {

	List<LavaRapido> listar();
	LavaRapido registrar(LavaRapidoDto lavaRapido);
	LavaRapido atualizar(LavaRapidoDto lavaRapido);
	LavaRapido excluir(Integer id);
	LavaRapido listarPorId(Integer id);
	
}
