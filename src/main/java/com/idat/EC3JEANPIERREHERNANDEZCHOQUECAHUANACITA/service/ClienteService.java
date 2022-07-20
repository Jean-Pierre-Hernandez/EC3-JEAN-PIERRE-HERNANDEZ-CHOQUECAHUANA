package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;

import java.util.List;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.ClienteDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.ClienteDTOResponse;

public interface ClienteService {
	
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);
	

}
