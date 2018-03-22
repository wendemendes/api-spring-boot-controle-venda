package com.controlevenda.cliente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.controlevenda.cliente.web.form.ClienteForm;

import lombok.Data;

@Entity
@Data
public class Cliente {
	
	@Id 
	@GeneratedValue
	private Integer clienteKey;
	
	private String nome;
	
	private String endereco;
	
	private String bairro;
	
	private String telefoneResidencial;
	
	private String telefoneCelular;
	
	private String email;
	
	public Cliente(){
	}
	
	private Cliente(ClienteForm form) {
		this.nome = form.getNome();
		this.endereco = form.getEndereco();
		this.bairro = form.getBairro();
		this.telefoneResidencial = form.getTelefoneResidencial();
		this.telefoneCelular = form.getTelefoneCelular();
		this.email = form.getEmail();
	}
	
	public static Cliente to(ClienteForm form){
		return new Cliente(form);
	}
	
}
