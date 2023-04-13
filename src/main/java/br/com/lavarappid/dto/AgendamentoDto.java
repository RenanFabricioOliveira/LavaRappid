package br.com.lavarappid.dto;

import lombok.Data;

@Data
public class AgendamentoDto {

	private int IdAgendamento;
	
	private String veiculo_placa;
	
	private String dataAgendamento;
	
	private String horarioAgendamento;
	
	private int servico_idServico;
	
	private int status;
	
	private String observacoes;

}
