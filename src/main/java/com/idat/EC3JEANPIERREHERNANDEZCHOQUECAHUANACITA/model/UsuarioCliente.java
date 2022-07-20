package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model;


import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "usuarios_clientes")
public class UsuarioCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String usuario;
	private String password;
	private String rol;
	
	@OneToOne
	@JoinColumn(
			name = "id_cliente", 
			nullable = false, 
			unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes(id_cliente)"))
	private Cliente cliente;
	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	



	
	
	
	
	
	
}