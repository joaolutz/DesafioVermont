package br.com.joaolutz.desafiovermont;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.joaolutz.desafiovermont.model.Gasto;

@SpringBootTest
@AutoConfigureMockMvc
class DesafioVermontApplicationTests {
	
	private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	private TestRestTemplate testRestTemplate = new TestRestTemplate(
			restTemplateBuilder.rootUri("http://localhost:8080/desafiovermont/api/v1"), "vermontAPI", "vermontAPIPassword");
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	void contextLoads() {
	}
    
    @Test
    void listarGastosTeste() throws Exception {
    	ResponseEntity<Gasto[]> responseEntity = testRestTemplate.getForEntity("/gastos", Gasto[].class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    
    @Test
    void consultarGastoPorIdTeste() throws Exception {
    	ResponseEntity<Gasto> responseEntity = testRestTemplate.getForEntity("/gastos/{id}", Gasto.class, 1);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    
    @Test
    void salvarGastoTeste() throws Exception {
    	Gasto gasto = new Gasto("João Gabriel Messi Lutz", "Teste Inclusão", new Date(), new BigDecimal(100.0), "Teste tags");
    	ResponseEntity<Gasto> responseEntity = testRestTemplate.postForEntity("/gastos", gasto, Gasto.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
    
    @Test
    void alterarGastoTeste() throws Exception {
    	Gasto gasto = new Gasto(1, "João Gabriel Messi Lutz", "Teste Alteração", new Date(), new BigDecimal(299.9), "Teste tags");
    	HttpEntity<Gasto> requestEntity = new HttpEntity<Gasto>(gasto);
    	ResponseEntity response = testRestTemplate.exchange("/gastos", HttpMethod.PUT, requestEntity, ResponseEntity.class);
    	assertNotNull(response);
    	assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    @Test
    void excluirGastoTeste() throws Exception {
    	Gasto gasto = new Gasto(2);
    	HttpEntity<Gasto> requestEntity = new HttpEntity<Gasto>(gasto);
    	ResponseEntity response = testRestTemplate.exchange("/gastos", HttpMethod.DELETE, requestEntity, ResponseEntity.class);
    	assertNotNull(response);
    	assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    //Teste Mockando API de terceiros (MockAPI)

    @Test
    public void listarGastosTesteMockado() throws Exception {
    	String url = "https://5f4cfcf0eeec51001608e70b.mockapi.io/desafiovermont/api/v1/gastos";
        ResponseEntity<Gasto[]> response = restTemplate.getForEntity(url, Gasto[].class);
        ResponseEntity<Gasto[]> responseEntity = testRestTemplate.getForEntity("/gastos", Gasto[].class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(response.getBody()[0].getIdGasto(), responseEntity.getBody()[0].getIdGasto());
    }

}
