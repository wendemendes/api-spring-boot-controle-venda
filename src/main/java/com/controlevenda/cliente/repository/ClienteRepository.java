package com.controlevenda.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlevenda.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
