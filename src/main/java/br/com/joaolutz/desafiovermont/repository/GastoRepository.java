package br.com.joaolutz.desafiovermont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joaolutz.desafiovermont.model.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {

	
}
