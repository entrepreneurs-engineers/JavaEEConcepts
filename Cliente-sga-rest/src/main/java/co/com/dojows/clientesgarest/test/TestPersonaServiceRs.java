package co.com.dojows.clientesgarest.test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.dojows.clientesgarest.domain.Persona;

public class TestPersonaServiceRs {
	
	private static final String URL_BASE = "http://localhost:8080/sga-jee-web-RestS/webservice";
	private static Client cliente;
	private static WebTarget webTarget;
	private static Persona persona;
	private static List<Persona> personas;
	private static Invocation.Builder invocationBuilder;
	private static Response response;
	
	public static void main(String[] args) {
		cliente = ClientBuilder.newClient();
		
		//Leer una persona (metodo get)
		webTarget = cliente.target(URL_BASE).path("/personas");
		//proporcionamos un idPersona valido
		persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
		System.out.println("Persona recuperada: " + persona);
		
		//Leer todas las personas (metodo get con readEntity de tipo List<>)
		personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity( new GenericType<List<Persona>>() {});
		
		personas.forEach(System.out::println);
		
		//Agregar una persona (metodo post)
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre("Dover");
		nuevaPersona.setApellido("Meneses");
		nuevaPersona.setEmail("dmeneses@mail.com");
		nuevaPersona.setTelefono("5721348");
		
		invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
		System.out.println();
		System.out.println("response post: "+response.getStatus());
		
		//recuperamos la persona recien agregada para modificarla y eliminarla
		Persona personaRecuperada = response.readEntity(Persona.class);
		System.out.println("Persona agregada: " + personaRecuperada);
		
		//Modificar la persona (metodo put)
		Persona personaModificar = personaRecuperada;
		personaModificar.setApellido("Ramirez");
		String pathId = "/" + personaModificar.getIdPersona();
		invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
		response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
		
		System.out.println();
		System.out.println("response put: " + response.getStatus());
		System.out.println("Persona modificada: " + response.readEntity(Persona.class));
		
		//eliminar una persona
		Persona personaElimnar = personaRecuperada;
		String pathEliminarId = "/" + personaElimnar.getIdPersona();
		invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
		response = invocationBuilder.delete();
		System.out.println();
		System.out.println("response delete: " + response.getStatus());
		System.out.println("Persona eliminada: " + personaElimnar);
	}
}
