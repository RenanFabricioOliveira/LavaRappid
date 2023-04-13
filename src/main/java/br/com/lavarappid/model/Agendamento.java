package br.com.lavarappid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="agendamento")
public class Agendamento {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdAgendamento;
	
	@ManyToOne
	@JoinColumn(name ="veiculo_Placa")
	private Veiculo veiculo_Placa;
	
	@Column
	private String dataAgendamento;
	
	@Column
	private String horarioAgendamento;
	
	@ManyToOne
	@JoinColumn(name ="servico_idServico")
	private Servico servico_idServico;

	@Column
	private int status;
	
	@Column
	private String observacoes;

}

