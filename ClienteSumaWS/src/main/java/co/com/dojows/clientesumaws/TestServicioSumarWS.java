package co.com.dojows.clientesumaws;

import co.com.dojows.clientesumaws.servicio.ServicioSumarImplService;
import co.com.dojows.clientesumaws.servicio.ServicioSumarWS;

public class TestServicioSumarWS {

	public static void main(String[] args) {
		ServicioSumarWS servicioSumarWS = new ServicioSumarImplService().getServicioSumarImplPort();
		
		System.out.println("Ejecutando servicio sumarWs");
		int arg0 = 6;
		int arg1 = 8;
		
		int response = servicioSumarWS.sumar(arg0, arg1);
		
		System.out.println("Resultado: " + response);
		System.out.println("Fin de servicio sumar Ws");
	}
}
