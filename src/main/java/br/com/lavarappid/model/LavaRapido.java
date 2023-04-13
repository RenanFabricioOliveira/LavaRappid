package br.com.lavarappid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="lavarapido")
public class LavaRapido {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdLavarapido;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column String senha;
	
	@Column
	private String telefone;
	
	@Column
	private String endereco;
	
	@Column
	private String cep;
	
}
