package br.com.joaolutz.desafiovermont.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaolutz.desafiovermont.model.Gasto;
import br.com.joaolutz.desafiovermont.service.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private GastoService gastoService;
	
	@GetMapping
	public ResponseEntity<List<Gasto>> listar() {
		return gastoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gasto> consultarPorId(@PathVariable Integer id) {
		return gastoService.consultarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<Gasto> salvar(@RequestBody Gasto gasto) {
		return gastoService.salvar(gasto);
	}
	
	@PutMapping
	public ResponseEntity alterar(@RequestBody Gasto gasto) {
		return gastoService.alterar(gasto);
	}
	
	@DeleteMapping
	public ResponseEntity excluir(@RequestBody Gasto gasto) {
		return gastoService.excluir(gasto);
	}
	
}
