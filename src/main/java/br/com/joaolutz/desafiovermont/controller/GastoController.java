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
import br.com.joaolutz.desafiovermont.repository.GastoRepository;

@RestController
@RequestMapping("/gasto")
public class GastoController {

	@Autowired
	private GastoRepository gastoRepository;
	
	@GetMapping
	public List<Gasto> listar() {
		return gastoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Gasto consultarPorId(@PathVariable Integer id) {
		return gastoRepository.findById(id).get();
	}
	
	@PostMapping
	public Gasto salvar(@RequestBody Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	@PutMapping
	public Gasto alterar(@RequestBody Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	@DeleteMapping
	public void excluir(@RequestBody Gasto gasto) {
		gastoRepository.delete(gasto);
	}
	
}
