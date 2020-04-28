package com.co.sga.services;

import java.util.List;

import javax.ejb.Local;

import com.co.sga.domain.Persona;
import com.co.sga.domain.Usuario;

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();

	public Persona encontrarPersonaPorId(Persona persona);

	public Persona encontrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);
	
	public List<Usuario> obtenerUsuariosPorIdPersona(Persona persona);
}
