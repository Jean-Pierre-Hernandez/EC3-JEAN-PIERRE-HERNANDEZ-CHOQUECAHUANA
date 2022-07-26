package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model.UsuarioCliente;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.repository.UsuarioClienteRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//UsuarioCliente usuariocliente = repository.findByUsuarioCliente(username);
		
		if("profesor".equals(username)){
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			//GrantedAuthority granted = new SimpleGrantedAuthority(usuariocliente.getRol());
			
			//listGranted.add(granted);
			
			return new User("profesor", "123456", listGranted);
			
			
		}else
			throw new UsernameNotFoundException("Usuario no existe ");
	}
}
