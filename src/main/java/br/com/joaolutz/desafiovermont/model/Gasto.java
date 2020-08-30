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

@Entity
@Table(name="gasto")
public class Gasto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer idGasto;
	@Column(name="NOME_PESSOA")
	private String nomePessoa;
	@Column(name="DESCRICAO")
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA")
	private Date dataHora;
	@Column(name="VALOR")
	private BigDecimal valor;
	@Column(name="TAGS")
	private String tags;
	
	public Gasto() {}
	
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
