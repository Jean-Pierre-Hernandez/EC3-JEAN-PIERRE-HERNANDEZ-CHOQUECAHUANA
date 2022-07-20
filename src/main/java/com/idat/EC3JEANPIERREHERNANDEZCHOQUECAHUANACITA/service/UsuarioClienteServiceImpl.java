package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTOResponse;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model.UsuarioCliente;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService{
	
	@Autowired
	private UsuarioClienteRepository repository;
	

	@Override
	public void guardarUsuarioCliente(UsuarioClienteDTORequest usuariocliente) {
		
		UsuarioCliente u = new UsuarioCliente();
		u.setUsuario(usuariocliente.getUsuario());
		u.setPassword(usuariocliente.getPassword());
		repository.save(u);	
	}

	@Override
	public void actualizarUsuarioCliente(UsuarioClienteDTORequest usuariocliente) {
		
		UsuarioCliente u = new UsuarioCliente();
		u.setUsuario(usuariocliente.getUsuario());
		u.setPassword(usuariocliente.getPassword());
		
		repository.saveAndFlush(u);
	}

	@Override
	public void eliminarUsuarioCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<UsuarioClienteDTOResponse> listarUsuarioCliente() {
		
		//List<UsuarioClienteDTOResponse> listar = new ArrayList<>();
		
		//UsuarioClienteDTOResponse dto = null;
		
		//List<UsuarioCliente> u = repository.findAll();
		
		//for (UsuarioCliente usuariocliente : u) {
			
		//	dto = new UsuarioClienteDTOResponse();
			
		//	dto.setToken(usuariocliente.getPassword());
		//}
		
		return null;
	}

	@Override
	public UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id) {
		
		return null;
	}

}
