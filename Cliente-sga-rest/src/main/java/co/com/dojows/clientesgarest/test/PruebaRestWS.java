package co.com.dojows.clientesgarest.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import co.com.dojows.clientesgarest.domain.Persona;

public class PruebaRestWS {

	public static void main(String[] args) {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature
				.basicBuilder()
				.nonPreemptive()
				.credentials("admin", "admin")
				.build();
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature);
		
		Client cliente = ClientBuilder.newClient(clientConfig);
		
		WebTarget webTarget = cliente.target("http://localhost:8080/sga-jee-web-RestS/webservice").path("/personas");
		
		Persona persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
		
		System.out.println("Persona recuperada: " + persona);
	}
}
