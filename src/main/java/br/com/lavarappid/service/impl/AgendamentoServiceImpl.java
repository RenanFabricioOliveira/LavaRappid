package br.com.lavarappid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lavarappid.dto.AgendamentoDto;
import br.com.lavarappid.dto.VeiculoDto;
import br.com.lavarappid.model.Agendamento;
import br.com.lavarappid.model.Cliente;
import br.com.lavarappid.model.Servico;
import br.com.lavarappid.model.Veiculo;
import br.com.lavarappid.repository.IAgendamentoRepository;
import br.com.lavarappid.service.IAgendamentoService;

@Service
public class AgendamentoServiceImpl implements IAgendamentoService {

	@Autowired
	IAgendamentoRepository repo;

	@Autowired
	private VeiculoServiceImpl veiculoServiceImpl;

	private Agendamento parseAgendamento(AgendamentoDto agendamentoDto) {

		Agendamento agendamento = new Agendamento();
		agendamento.setIdAgendamento(agendamentoDto.getIdAgendamento());
		agendamento.setDataAgendamento(agendamentoDto.getDataAgendamento());
		agendamento.setHorarioAgendamento(agendamentoDto.getHorarioAgendamento());
		agendamento.setStatus(agendamentoDto.getStatus());
		agendamento.setObservacoes(agendamentoDto.getObservacoes());

		VeiculoDto veiculoDto = new VeiculoDto();
		Cliente cliente = new Cliente();
		cliente.setCpf(veiculoDto.getCliente_cpf());

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(agendamentoDto.getVeiculo_Placa());
		veiculo.setCliente_cpf(cliente);
		agendamento.setVeiculo_Placa(veiculo);

		Servico servico = new Servico();
		servico.setIdServico(agendamentoDto.getServico_idServico());
		agendamento.setServico_idServico(servico);

		return agendamento;

	}

	@Override
	public List<Agendamento> listar() {
		return repo.findAll();
	}

	@Override
	public Agendamento registrar(AgendamentoDto agendamentoDTO) {
		Veiculo listarPorPlaca = veiculoServiceImpl.listarPorPlaca(agendamentoDTO.getVeiculo_Placa());
		Agendamento retorno = new Agendamento();

		if ( listarPorPlaca != null) {
			retorno = repo.save(parseAgendamento(agendamentoDTO));
		}
		return retorno;
	}

	@Override
	public Agendamento atualizar(Agendamento agendamento) {
		return repo.save(agendamento);
	}

	@Override
	public Agendamento excluir(int id) {
		Agendamento agendamento = repo.findById(id).orElse(null);
		if (agendamento != null) {
			repo.delete(agendamento);
		}
		return agendamento;
	}

	@Override
	public Agendamento listarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

}
