package com.example.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;

	@NotBlank(message = "Não pode ser nulo nem pode ser preenchido pela tecla espaço")
	@Size(min = 10, max = 100)
	private String titulo;

	@NotBlank(message = "Não pode ser nulo nem pode ser preenchido pela tecla espaço")
	private BigDecimal preco;

	@NotBlank(message = "Não pode ser nulo nem pode ser preenchido pela tecla espaço")
	@Size(min = 10, max = 100)
	private String laboratorio;

	// CHAVE ESTRANGEIRA
	@ManyToOne // N: 1
	@JsonIgnoreProperties("categoria") // não permitir que repita as informações
	@JoinColumn(name = "fk_id_categoria")
	private CategoriaModel categoria;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

}
