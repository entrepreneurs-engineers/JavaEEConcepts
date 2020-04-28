package com.co.sga.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.co.sga.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao{

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager entityManager;

	@Override
	public List<Persona> findAllPersonas() {
		return entityManager.createNamedQuery("Persona.findAll", Persona.class).getResultList();
	}

	@Override
	public Persona findPersonaById(Persona persona) {
		return entityManager.find(Persona.class, persona.getIdPersona());
	}

	@Override
	public Persona findPersonaByEmail(Persona persona) {
		TypedQuery<Persona> query = entityManager.createQuery("from Persona p where p.email = :email", Persona.class);
		query.setParameter("email", persona.getEmail());
		return query.getSingleResult();
	}

	@Override
	public void insertPersona(Persona persona) {
		entityManager.persist(persona);
	}

	@Override
	public void updatePersona(Persona persona) {
		entityManager.merge(persona);
	}

	@Override
	public void deletePersona(Persona persona) {
		entityManager.remove(entityManager.merge(persona));
	}
	
}
