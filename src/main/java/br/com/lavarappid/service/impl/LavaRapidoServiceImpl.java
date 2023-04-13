package br.com.lavarappid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lavarappid.dto.LavaRapidoDto;
import br.com.lavarappid.model.LavaRapido;
import br.com.lavarappid.repository.ILavaRapidoRepository;
import br.com.lavarappid.service.ILavaRapidoService;

@Service
public class LavaRapidoServiceImpl implements ILavaRapidoService{
	
	@Autowired
	ILavaRapidoRepository repo;

	
	private LavaRapido parseLavaRapido(LavaRapidoDto lavaRapidoDto) {

		LavaRapido lavaRapido = new LavaRapido();
		lavaRapido.setIdLavarapido(lavaRapidoDto.getIdLavarapido());
		lavaRapido.setNome(lavaRapidoDto.getNome());
		lavaRapido.setEmail(lavaRapidoDto.getEmail());
		lavaRapido.setSenha(lavaRapidoDto.getEndereço());
		lavaRapido.setEndereco(lavaRapidoDto.getEndereço());
		lavaRapido.setCep(lavaRapidoDto.getCep());
		lavaRapido.setTelefone(lavaRapidoDto.getTelefone());
		
		return lavaRapido;
	}
	
	@Override
	public List<LavaRapido> listar() {
		return repo.findAll();
	}

	@Override
	public LavaRapido registrar(LavaRapidoDto lavaRapidoDto) {
		LavaRapido lavaRapido = parseLavaRapido(lavaRapidoDto);
		return repo.save(lavaRapido);
	}

	@Override
	public LavaRapido atualizar(LavaRapidoDto lavaRapidoDto) {
		LavaRapido lavaRapido = parseLavaRapido(lavaRapidoDto);
		return repo.save(lavaRapido);
	}

	@Override
	public LavaRapido excluir(Integer id) {
		LavaRapido lavaRapido = repo.findById(id).orElse(null);
		if (lavaRapido != null) {
			repo.delete(lavaRapido);
		}
		return lavaRapido;
	}

	@Override
	public LavaRapido listarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
