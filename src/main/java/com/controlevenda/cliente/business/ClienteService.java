package com.controlevenda.cliente.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlevenda.cliente.model.Cliente;
import com.controlevenda.cliente.repository.ClienteRepository;
import com.controlevenda.cliente.web.form.ClienteForm;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository){
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente salvar(ClienteForm clienteForm){
		
		return clienteRepository.save(Cliente.to(clienteForm));
			
	}
	
	@Transactional
	public Cliente alterar(Cliente cliente, ClienteForm clienteForm){
		

		ValidadorCliente.validarCliente(cliente);
	
		cliente.setBairro(clienteForm.getBairro());
		cliente.setEmail(clienteForm.getEmail());
		cliente.setEndereco(clienteForm.getEndereco());
		cliente.setNome(clienteForm.getNome());
		cliente.setTelefoneCelular(clienteForm.getTelefoneCelular());
		cliente.setTelefoneResidencial(clienteForm.getTelefoneResidencial());
		
		clienteRepository.save(cliente);
		
		return cliente;
	}

	

}
