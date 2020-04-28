package com.co.sga.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.co.sga.domain.Persona;
import com.co.sga.services.PersonaService;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonaService personaService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Persona> personas = personaService.listarPersonas();
		System.out.println(personas);
		
		personas.forEach(persona -> persona.setUsuarios(personaService.obtenerUsuariosPorIdPersona(persona)));
		
		request.setAttribute("personas", personas);
		request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
	}

}
