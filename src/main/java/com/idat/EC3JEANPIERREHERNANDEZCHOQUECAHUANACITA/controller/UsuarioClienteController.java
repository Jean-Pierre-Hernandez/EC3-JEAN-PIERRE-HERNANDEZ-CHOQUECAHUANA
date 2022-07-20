package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.UsuarioClienteDTOResponse;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service.UsuarioClienteService;


@Controller
@RequestMapping( path = "/usuariocliente/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioClienteDTOResponse>>  listar() {
		
		return new ResponseEntity<List<UsuarioClienteDTOResponse>>(service.listarUsuarioCliente(),HttpStatus.OK);
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteDTORequest usuariocliente){
		service.guardarUsuarioCliente(usuariocliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		UsuarioClienteDTOResponse u =service.obtenerUsuarioClienteId(id);
		if(u != null) {
			service.eliminarUsuarioCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}
	
//	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
//	public ResponseEntity<Void> actualizar(@RequestBody UsuarioClienteDTORequest usuariocliente){
//		UsuarioClienteDTOResponse u=service.obtenerUsuarioClienteId(usuariocliente.getUsuario());
//		if(u != null) {
//			service.actualizarUsuarioCliente(usuariocliente);
//			return  new ResponseEntity<Void>(HttpStatus.OK);
//		}
//		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTOResponse> obtenerId(@PathVariable Integer id) {
		UsuarioClienteDTOResponse u =service.obtenerUsuarioClienteId(id);
		if(u != null) {
			return  new ResponseEntity<UsuarioClienteDTOResponse>(service.obtenerUsuarioClienteId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<UsuarioClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
