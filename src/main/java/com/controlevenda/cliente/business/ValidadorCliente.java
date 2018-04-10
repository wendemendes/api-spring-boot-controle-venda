package com.controlevenda.cliente.business;

import com.controlevenda.cliente.model.Cliente;
import com.controlevenda.exception.ObjetoNaoEncontradoException;

public class ValidadorCliente {
	
	public static void validarCliente(Cliente cliente) {
		
		if (cliente == null) {
			throw new ObjetoNaoEncontradoException("Cliente não encontrado"); 
		}
	}

}
