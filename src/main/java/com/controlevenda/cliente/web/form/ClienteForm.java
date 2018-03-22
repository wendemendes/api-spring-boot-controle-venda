package com.controlevenda.cliente.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ClienteForm {
	
	@NotEmpty(message = "Informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Informe o endereço do cliente")
	private String endereco;
	
	@NotEmpty(message = "Informe o bairro do cliente")
	private String bairro;
	
	private String telefoneResidencial;
	
	@NotEmpty(message = "Informe o celular do cliente")
	private String telefoneCelular;
	
	@NotEmpty(message = "Informe o email do cliente")
	private String email;

}
