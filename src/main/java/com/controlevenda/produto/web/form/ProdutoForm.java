package com.controlevenda.produto.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProdutoForm {
	
	@NotEmpty(message = "Informe a descrição do produto")
	private String descricao;
	
	@NotEmpty(message = "Informe o GTIN do produto")
	private String gtin;

}
