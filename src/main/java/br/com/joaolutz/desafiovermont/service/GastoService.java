package br.com.joaolutz.desafiovermont.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.joaolutz.desafiovermont.model.Gasto;
import br.com.joaolutz.desafiovermont.repository.GastoRepository;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository gastoRepository;
	
	public List<Gasto> listar() {
		return gastoRepository.findAll();
	}
	
	public Gasto consultarPorId(@PathVariable Integer id) {
		return gastoRepository.findById(id).get();
	}
	
	public Gasto salvar(@RequestBody Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	public Gasto alterar(@RequestBody Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	public Status excluir(@RequestBody Gasto gasto) {
		if(gastoRepository.existsById(gasto.getIdGasto())) {
			gastoRepository.delete(gasto);
			return new Status("Gasto excluído com sucesso.");
		} else {
			return new Status(1, "Gasto não encontrado. Verifique os dados informados.");
		}
	}

}
