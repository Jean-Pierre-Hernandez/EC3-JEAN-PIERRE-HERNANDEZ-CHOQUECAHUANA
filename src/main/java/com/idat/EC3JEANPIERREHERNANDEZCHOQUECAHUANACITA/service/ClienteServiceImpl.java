package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.ClienteDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.ClienteDTOResponse;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model.Cliente;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombre());
		c.setCelular(c.getCelular());
		repository.save(c);
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setCelular(c.getCelular());
		
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for (Cliente clientes : c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setIdCliente(clientes.getIdCliente());
			dto.setNombre(clientes.getNombre());
			dto.setCelular(clientes.getCelular());
			
			listar.add(dto);
					
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente clientes = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setIdCliente(clientes.getIdCliente());
		dto.setNombre(clientes.getNombre());
		dto.setCelular(clientes.getCelular());	
		return dto;
	}
	

}
