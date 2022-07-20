package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;

import java.util.List;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTOResponse;

public interface UsuarioClienteService {

	
	void guardarUsuarioCliente(UsuarioClienteDTORequest usuariocliente);
	void actualizarUsuarioCliente(UsuarioClienteDTORequest usuariocliente);
	void eliminarUsuarioCliente(Integer id);
	List<UsuarioClienteDTOResponse> listarUsuarioCliente();
	UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id);
}
