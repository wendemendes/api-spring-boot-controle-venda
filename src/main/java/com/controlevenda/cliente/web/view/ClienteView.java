package com.controlevenda.cliente.web.view;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.controlevenda.cliente.business.ValidadorCliente;
import com.controlevenda.cliente.model.Cliente;


public class ClienteView {
	
	private Integer clienteKey;
	
	private String nome;
	
	private String endereco;
	
	private String bairro;
	
	private String telefoneResidencial;
	
	private String telefoneCelular;
	
	private String email;
	
	private ClienteView(Cliente cliente) {
		this.clienteKey = cliente.getClienteKey();
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.bairro = cliente.getBairro();
		this.telefoneResidencial = cliente.getTelefoneResidencial();
		this.telefoneCelular = cliente.getTelefoneCelular();
		this.email = cliente.getEmail();
	}

	public static List<ClienteView> toList(List<Cliente> clientes){
		
		if(clientes.isEmpty()){
			return Collections.emptyList();
		}
		
		return clientes
		.stream()
		.map(cliente -> toView(Optional.of(cliente)))
		.collect(Collectors.toList());
		
	}
	
	public static ClienteView toView(Optional<Cliente> clienteOptional){
		
		return new ClienteView(clienteOptional.get());
	}

	public Integer getClienteKey() {
		return clienteKey;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getEmail() {
		return email;
	}
}
