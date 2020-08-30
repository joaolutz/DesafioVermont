package br.com.joaolutz.desafiovermont.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaolutz.desafiovermont.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {

	
}
