package br.com.lavarappid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavarappid.model.Agendamento;

public interface IAgendamentoRepository extends JpaRepository<Agendamento, Integer> {


}
