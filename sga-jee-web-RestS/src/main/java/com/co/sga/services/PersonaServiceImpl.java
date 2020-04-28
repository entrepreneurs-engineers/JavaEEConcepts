package com.co.sga.services;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import com.co.sga.data.PersonaDao;
import com.co.sga.data.UsuarioDao;
import com.co.sga.domain.Persona;
import com.co.sga.domain.Usuario;

@Stateless
@WebService(endpointInterface = "com.co.sga.services.PersonaServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWs{

	@Inject
	private PersonaDao personaDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	@Override
	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	@Override
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	@Override
	@RolesAllowed("ROLE_ADMIN")
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

	@Override
	public List<Usuario> obtenerUsuariosPorIdPersona(Persona persona) {
		return usuarioDao.findUsuariosByIdPersona(persona);
	}

}
