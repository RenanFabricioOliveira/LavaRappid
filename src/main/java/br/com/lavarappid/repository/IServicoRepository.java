package br.com.lavarappid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavarappid.model.Servico;

public interface IServicoRepository extends JpaRepository<Servico, Integer> {


}
