package com.controlevenda.produto.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlevenda.produto.model.Produto;
import com.controlevenda.produto.repository.ProdutoRepository;
import com.controlevenda.produto.web.form.ProdutoForm;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository){
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional
	public Produto salvar(ProdutoForm produtoForm){
		
		return produtoRepository.save(Produto.to(produtoForm));
			
	}
	
	@Transactional
	public Produto alterar(Produto produto, ProdutoForm produtoForm){
		
		ValidadorProduto.validarProduto(produto);
	
		produto.setDescricao(produtoForm.getDescricao());
		produto.setGtin(produtoForm.getGtin());
		
		produtoRepository.save(produto);
		
		return produto;
	}


}
