package br.com.joaolutz.desafiovermont.model;

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
public class Gasto {

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
