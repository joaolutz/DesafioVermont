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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private GastoService gastoService;
	
	@ApiOperation(value = "Retorna uma lista de gastos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
	    @ApiResponse(code = 204, message = "Nenhum registro foi encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@GetMapping
	public ResponseEntity<List<Gasto>> listar() {
		return gastoService.listar();
	}
	
	@ApiOperation(value = "Retorna um gasto pelo id")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna o gasto solicitado"),
	    @ApiResponse(code = 404, message = "O registro não foi localizado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@GetMapping(path="/{id}", produces="application/json")
	public ResponseEntity<Gasto> consultarPorId(@PathVariable Integer id) {
		return gastoService.consultarPorId(id);
	}
	
	@ApiOperation(value = "Realiza o cadastro um gasto")
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "O gasto foi cadastrado com sucesso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Gasto> salvar(@RequestBody Gasto gasto) {
		return gastoService.salvar(gasto);
	}
	
	@ApiOperation(value = "Altera um gasto cadastrado")
	@ApiResponses(value = {
	    @ApiResponse(code = 204, message = "O registro foi alterado com sucesso"),
	    @ApiResponse(code = 404, message = "O registro não foi localizado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(consumes="application/json")
	public ResponseEntity alterar(@RequestBody Gasto gasto) {
		return gastoService.alterar(gasto);
	}
	
	@ApiOperation(value = "Exclui um gasto cadastrado")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "O registro foi excluído com sucesso"),
		    @ApiResponse(code = 404, message = "O registro não foi localizado"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@DeleteMapping(consumes="application/json")
	public ResponseEntity excluir(@RequestBody Gasto gasto) {
		return gastoService.excluir(gasto);
	}
	
}
