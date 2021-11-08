package com.example.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	@NotBlank(message = "Não pode ser nulo nem pode ser preenchido pela tecla espaço")
	@Size(min = 10, max = 1000)
	private String descricao;

	@NotBlank(message = "Não pode ser nulo nem pode ser preenchido pela tecla espaço")
	@Size(min = 10, max = 1000)
	private String tipo;

	// mappedby --> qual o lado inverso da operação
	// cascade --> o que uma tabela fizer, funcionará nas outras
	// @JsonIgnoreProperties --> deleta as repetições e só mostra onde está alocado

	// 1: N
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // SELECT TABLE INNER JOIN -- ON
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produto;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

}
