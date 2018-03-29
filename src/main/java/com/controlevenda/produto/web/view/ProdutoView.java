package com.controlevenda.produto.web.view;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.controlevenda.produto.model.Produto;

public class ProdutoView {
	
		
		private Integer produtoKey;
		
		private String descricao;
		
		private String gtin;
	
		private ProdutoView(Produto produto) {
			this.produtoKey = produto.getProdutoKey();
			this.descricao = produto.getDescricao();
			this.gtin = produto.getGtin();
			
		}

		public static List<ProdutoView> toList(List<Produto> produtos){
			
			if(produtos.isEmpty()){
				return Collections.emptyList();
			}
			
			return produtos
			.stream()
			.map(produto -> toView(Optional.of(produto)))
			.collect(Collectors.toList());
			
		}
		
		public static ProdutoView toView(Optional<Produto> produtoOptional){
			return new ProdutoView(produtoOptional.get());
		}

		public Integer getProdutoKey() {
			return produtoKey;
		}

		public String getDescricao() {
			return descricao;
		}

		public String getGtin() {
			return gtin;
		}
}
