package com.controlevenda.produto.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlevenda.produto.business.ProdutoService;
import com.controlevenda.produto.model.Produto;
import com.controlevenda.produto.repository.ProdutoRepository;
import com.controlevenda.produto.web.form.ProdutoForm;
import com.controlevenda.produto.web.view.ProdutoView;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoView> listar(){
		
		return ProdutoView.toList(produtoRepository.findAll());
	}
	
	@GetMapping("/{produtoKey}")
	public ResponseEntity<ProdutoView> obter(@PathVariable Integer produtoKey){
		
		Produto produto = produtoRepository.findOne(produtoKey);
		
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ProdutoView.toView(Optional.ofNullable(produto))) ;
	}
	
	@PutMapping("/{produtoKey}")
	public ResponseEntity<ProdutoView> alterar(@PathVariable Integer produtoKey, @Valid @RequestBody ProdutoForm produtoForm){
		
		Produto produto = produtoRepository.findOne(produtoKey);
		
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		produtoService.alterar(produto, produtoForm);
		
		return ResponseEntity.ok(ProdutoView.toView(Optional.ofNullable(produto))) ;
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ProdutoView> salvar(@Valid @RequestBody ProdutoForm produtoForm){
	
			return ResponseEntity.ok(ProdutoView.toView(Optional.of(produtoService.salvar(produtoForm)))) ;

	}
	
	@DeleteMapping("/{produtoKey}")
	public ResponseEntity<Void> excluir(@PathVariable Integer produtoKey){
		
		Produto produto = produtoRepository.findOne(produtoKey);
		
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		
		produtoRepository.delete(produto);
		
		return ResponseEntity.noContent().build() ;
	}

}
