package br.com.lavarappid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lavarappid.dto.ServicoDto;
import br.com.lavarappid.model.Servico;
import br.com.lavarappid.repository.IServicoRepository;
import br.com.lavarappid.service.IServicoService;

@Service
public class ServicoServiceImpl implements IServicoService{
	
	@Autowired
	private IServicoRepository repo;
	
	private Servico parseServico(ServicoDto servicoDto) {

		Servico servico = new Servico();
		servico.setIdServico(servicoDto.getIdServico());
		servico.setDescricao(servicoDto.getDescricao());
		servico.setValor(servicoDto.getValor());
		
		return servico;
	}
		
	@Override
	public List<Servico> listar() {
		return repo.findAll();
	}

	@Override
	public Servico registrar(ServicoDto servicoDto) {
		Servico servico = parseServico(servicoDto);
		return repo.save(servico);
	}

	@Override
	public Servico atualizar(Servico servico) {
		return repo.save(servico);
	}

	@Override
	public Servico excluir(Integer id) {
		Servico servico = repo.findById(id).orElse(null);
		if (servico != null) {
			repo.delete(servico);
		}
		return servico;
	}

	@Override
	public Servico listarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}


}
