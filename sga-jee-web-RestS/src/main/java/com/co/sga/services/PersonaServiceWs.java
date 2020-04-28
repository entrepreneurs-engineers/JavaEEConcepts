package com.co.sga.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.co.sga.domain.Persona;

@WebService
public interface PersonaServiceWs {

	@WebMethod
	public List<Persona> listarPersonas();
}
