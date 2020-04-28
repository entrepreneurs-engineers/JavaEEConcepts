package com.co.sga.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.co.sga.domain.Persona;
import com.co.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager entityManager;

	@Override
	public List<Usuario> findUsuariosByIdPersona(Persona persona) {
		TypedQuery<Usuario> query = entityManager.createQuery("SELECT us FROM Persona p, Usuario us WHERE us = p.usuarios AND p.idPersona = :idPersona", Usuario.class);
		query.setParameter("idPersona", persona.getIdPersona());
		return query.getResultList();
	}
}
