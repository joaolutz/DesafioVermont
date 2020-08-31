package br.com.joaolutz.desafiovermont.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="gasto")
public class Gasto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Id do gasto")
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer idGasto;
	
	@ApiModelProperty(value = "Nome da Pessoa")
	@Column(name="NOME_PESSOA")
	private String nomePessoa;
	
	@ApiModelProperty(value = "Descrição do gasto")
	@Column(name="DESCRICAO")
	private String descricao;
	
	@ApiModelProperty(value = "Data/Hora do gasto")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA")
	private Date dataHora;
	
	@ApiModelProperty(value = "Valor do gasto")
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@ApiModelProperty(value = "Tags relacionadas ao gasto")
	@Column(name="TAGS")
	private String tags;
	
	public Gasto() {}
	
	public Gasto(Integer idGasto) {
		this.idGasto = idGasto;
	}
	
	public Gasto(String nomePessoa, String descricao, Date dataHora, BigDecimal valor, String tags) {
		this(null, nomePessoa, descricao, dataHora, valor, tags);
	}
	
	public Gasto(Integer idGasto, String nomePessoa, String descricao, Date dataHora, BigDecimal valor, String tags) {
		this.idGasto = idGasto;
		this.nomePessoa = nomePessoa;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.valor = valor;
		this.tags = tags;
	}

	public Integer getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(Integer idGasto) {
		this.idGasto = idGasto;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
