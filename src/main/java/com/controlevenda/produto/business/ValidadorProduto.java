package com.controlevenda.produto.business;

import com.controlevenda.exception.ObjetoNaoEncontradoException;
import com.controlevenda.produto.model.Produto;

public class ValidadorProduto {
	
	public static void validarProduto(Produto produto) {
		
		if (produto == null) {
			throw new ObjetoNaoEncontradoException("Produto não encontrado"); 
		}
	}
	
	

}
