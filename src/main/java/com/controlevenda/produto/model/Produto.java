package com.controlevenda.produto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.controlevenda.produto.web.form.ProdutoForm;

import lombok.Data;

@Entity
@Data
public class Produto {
	
	@Id 
	@GeneratedValue
	private Integer produtoKey;
	
	private String descricao;
	
	private String gtin;
	
	public Produto() {
		
	}
	
	private Produto(ProdutoForm form) {
		this.descricao = form.getDescricao();
		this.gtin = form.getGtin();
		
	}
	
	public static Produto to(ProdutoForm form){
		return new Produto(form);
	}

}
