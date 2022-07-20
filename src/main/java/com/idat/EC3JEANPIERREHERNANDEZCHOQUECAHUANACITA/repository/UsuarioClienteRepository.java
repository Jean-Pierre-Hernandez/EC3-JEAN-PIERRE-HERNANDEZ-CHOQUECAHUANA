package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{
	/*
	UsuarioCliente findByUsuarioCliente(String usuarioCliente);*/
	
	
}
