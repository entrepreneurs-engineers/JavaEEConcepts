package com.co.sga.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona", unique=true, nullable=false)
	private int idPersona;

	@Column(length=45)
	private String apellido;

	@Column(length=45)
	private String email;

	@Column(length=45)
	private String nombre;

	@Column(length=45)
	private String telefono;

	@XmlTransient
	@OneToMany(
	        mappedBy = "persona",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private List<Usuario> usuarios;

	public Persona() {
	}
	
	public Persona(int id) {
		this.idPersona = id;
	}

	public Persona(String apellido, String email, String nombre, String telefono) {
		super();
		this.apellido = apellido;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellido=" + apellido + ", email=" + email + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}

}