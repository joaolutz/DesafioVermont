package br.com.joaolutz.desafiovermont.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.joaolutz.desafiovermont.model.Gasto;
import br.com.joaolutz.desafiovermont.repository.GastoRepository;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository gastoRepository;
	
	public ResponseEntity<List<Gasto>> listar() {
		List<Gasto> gastos = gastoRepository.findAll();
		if(!gastos.isEmpty()) {
			return ResponseEntity.ok(gastos);
		}
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Gasto> consultarPorId(@PathVariable Integer id) {
		return ResponseEntity.of(gastoRepository.findById(id));
	}
	
	public ResponseEntity<Gasto> salvar(@RequestBody Gasto gasto) {
		Gasto newGasto = gastoRepository.save(gasto);
		return ResponseEntity.created(UriComponentsBuilder.newInstance().scheme("http")
				.host("localhost:8080").path("/desafiovermont/api/v1/gastos/{id}")
				.buildAndExpand(gasto.getIdGasto()).encode().toUri()).body(newGasto);
	}
	
	public ResponseEntity alterar(@RequestBody Gasto gasto) {
		if(gastoRepository.existsById(gasto.getIdGasto())) {
			gastoRepository.save(gasto);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity excluir(@RequestBody Gasto gasto) {
		if(gastoRepository.existsById(gasto.getIdGasto())) {
			gastoRepository.delete(gasto);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
