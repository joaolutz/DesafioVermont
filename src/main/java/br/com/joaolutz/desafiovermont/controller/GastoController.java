package br.com.joaolutz.desafiovermont.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.joaolutz.desafiovermont.service.Status;

@RestController
@RequestMapping("/gasto")
public class GastoController {

	@Autowired
	private GastoService gastoService;
	
	@GetMapping
	public List<Gasto> listar() {
		return gastoService.listar();
	}
	
	@GetMapping("/{id}")
	public Gasto consultarPorId(@PathVariable Integer id) {
		return gastoService.consultarPorId(id);
	}
	
	@PostMapping
	public Gasto salvar(@RequestBody Gasto gasto) {
		return gastoService.salvar(gasto);
	}
	
	@PutMapping
	public Gasto alterar(@RequestBody Gasto gasto) {
		return gastoService.alterar(gasto);
	}
	
	@DeleteMapping
	public Status excluir(@RequestBody Gasto gasto) {
		return gastoService.excluir(gasto);
	}
	
}
