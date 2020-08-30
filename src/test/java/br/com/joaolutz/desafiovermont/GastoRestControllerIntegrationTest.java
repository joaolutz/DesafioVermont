package br.com.joaolutz.desafiovermont;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.joaolutz.desafiovermont.controller.GastoController;
import br.com.joaolutz.desafiovermont.model.Gasto;
import br.com.joaolutz.desafiovermont.service.GastoService;
import springfox.documentation.spring.web.json.Json;

@RunWith(SpringRunner.class)
@WebMvcTest(GastoController.class)
public class GastoRestControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	private ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void listarGastosTeste() throws Exception {
        mvc.perform(get("/gasto")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].idGasto", is(1)));
    }
    
    @Test
    public void consultarGastoPorIdTeste() throws Exception {
        mvc.perform(get("/gasto/1")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.idGasto", is(1)));
    }
    
    @Test
    public void salvarGastoTeste() throws Exception {
    	Gasto gasto = new Gasto("João Gabriel Messi Lutz", "Teste", new Date(), new BigDecimal(399.9), "Teste tags");
        mvc.perform(post("/gasto")
        		.content(mapper.writeValueAsString(gasto))
        	.accept(MediaType.APPLICATION_JSON)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].id", is(gasto.getIdGasto())));
    }
    
    @Test
    public void alterarGastoTeste() throws Exception {
    	Gasto gasto = new Gasto("João Gabriel Messi Lutz", "Teste", new Date(), new BigDecimal(399.9), "Teste tags");
        mvc.perform(put("/gasto")
        		.content(mapper.writeValueAsString(gasto))
        	.accept(MediaType.APPLICATION_JSON)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].id", is(gasto.getIdGasto())));
    }
    
    @Test
    public void excluirGastoTeste() throws Exception {
    	Gasto gasto = new Gasto("João Gabriel Messi Lutz", "Teste", new Date(), new BigDecimal(399.9), "Teste tags");
        mvc.perform(delete("/gasto")
        		.content(mapper.writeValueAsString(gasto))
        	.accept(MediaType.APPLICATION_JSON)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].id", is(gasto.getIdGasto())));
    }

}
