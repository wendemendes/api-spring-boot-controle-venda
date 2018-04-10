package com.controlevenda.cliente.web.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlevenda.cliente.business.ClienteService;
import com.controlevenda.cliente.business.ValidadorCliente;
import com.controlevenda.cliente.model.Cliente;
import com.controlevenda.cliente.repository.ClienteRepository;
import com.controlevenda.cliente.web.form.ClienteForm;
import com.controlevenda.cliente.web.view.ClienteView;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
		this.clienteRepository = clienteRepository;
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<ClienteView> listar(){
		
		return ClienteView.toList(clienteRepository.findAll());
	}
	
	@GetMapping("/{clienteKey}")
	public ResponseEntity<ClienteView> obter(@PathVariable Integer clienteKey){
		
		Cliente cliente = clienteRepository.findOne(clienteKey);
		ValidadorCliente.validarCliente(cliente);
		ClienteView clienteView = ClienteView.toView(Optional.ofNullable(cliente));
		
		return ResponseEntity.ok(clienteView) ;
	}
	
	@PutMapping("/{clienteKey}")
	public ResponseEntity<ClienteView> alterar(@PathVariable Integer clienteKey, @Valid @RequestBody ClienteForm clienteForm){
		
		Cliente cliente = clienteRepository.findOne(clienteKey);
		clienteService.alterar(cliente, clienteForm);
		
		return ResponseEntity.ok(ClienteView.toView(Optional.ofNullable(cliente))) ;
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ClienteView> salvar(@Valid @RequestBody ClienteForm clienteForm){
	
			ClienteView clienteView = ClienteView.toView(Optional.of(clienteService.salvar(clienteForm)));
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteView);
	}
	
	@DeleteMapping("/{clienteKey}")
	public ResponseEntity<Void> excluir(@PathVariable Integer clienteKey){
		
		Cliente cliente = clienteRepository.findOne(clienteKey);
		ValidadorCliente.validarCliente(cliente);
		
		clienteRepository.delete(cliente);
		
		return ResponseEntity.noContent().build() ;
	}	

}
