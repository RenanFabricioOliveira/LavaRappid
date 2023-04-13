package br.com.lavarappid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lavarappid.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, String> {

}
