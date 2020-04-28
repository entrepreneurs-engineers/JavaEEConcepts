package com.co.sga.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.co.sga.domain.Persona;
import com.co.sga.services.PersonaService;

@Named("personaBean")
@RequestScoped
public class PersonaBean {
	
	Logger log = LogManager.getRootLogger();

	@Inject
	private PersonaService personaService;
	
	private Persona personaSeleccionada;
	
	private List<Persona> personas;
	
	public PersonaBean() {
		log.debug("Iniciando el objeto PersonaBean");
	}
	
	@PostConstruct
	public void inicializar() {
		//Iniciamos las variables posterior al constructor
		personas = personaService.listarPersonas();
		log.debug("Personas recuperadas en ManagedBean= {0}",personas);
		this.personaSeleccionada = new Persona();
	}
	
	public void editListener(RowEditEvent event) {
		Persona persona = (Persona) event.getObject();
		personaService.modificarPersona(persona);
	}
	
	public void agregarPersona() {
		this.personaService.registrarPersona(personaSeleccionada);
		this.personas.add(personaSeleccionada);
		this.personaSeleccionada = null;
	}
	
	public void eliminarPersona() {
		this.personaService.eliminarPersona(personaSeleccionada);
		this.personas.remove(personaSeleccionada);
		this.personaSeleccionada = null;
	}
	
	public void reiniciarPersonaSeleccionada() {
		this.personaSeleccionada = new Persona();
	}

	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
