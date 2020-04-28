package co.com.dojows.ClienteEJBSeguridad.main;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;

import co.com.dojows.ClienteEJBSeguridad.domain.Persona;
import co.com.dojows.ClienteEJBSeguridad.service.PersonaServiceRemote;

/**
 * Hello world!
 *
 */
public class ClientePersonaService {
	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente");
		
		String authFile = "login.conf";
		System.setProperty("java.security.auth.login.config", authFile);
		ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
		programmaticLogin.login("admin", "admin".toCharArray());
		
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-RestS/PersonaServiceImpl!com.co.sga.services.PersonaServiceRemote");
			
			List<Persona> personas = personaService.listarPersonas();
			
			personas.forEach(System.out::println);
			
			System.out.println("\n Fin del llamado...");
			
		} catch (NamingException e) {
			e.printStackTrace(System.out);
		}
	}
}
