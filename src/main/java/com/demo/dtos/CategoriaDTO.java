package com.demo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.demo.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo NOME é obrigatório")
	@Length(min = 3, max = 100, message = "O campo NOME deve ter no mínimo 3 carateres e no máximo 100")
	private String nome;
	
	@NotEmpty(message = "O campo DESCRIÇÃO é obrigatório")
	@Length(min=3, max=100, message = "O campo DESCRIÇÃO deve ter no mínimo 3 carateres e no máximo 200")
	private String descricao;
	
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
