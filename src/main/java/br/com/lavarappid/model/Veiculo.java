package br.com.lavarappid.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="veiculo")
public class Veiculo {

	@Id
	@Column
	private String placa;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cliente_cpf")
	private Cliente cliente_cpf;
	
	@Column
	private String modelo;
	
	@Column
	private String cor;
	
	@Column
	private String porte;
	
}
