package com.controlevenda.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlevenda.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
