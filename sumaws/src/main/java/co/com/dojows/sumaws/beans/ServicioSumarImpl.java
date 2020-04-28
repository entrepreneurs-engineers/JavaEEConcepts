package co.com.dojows.sumaws.beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "co.com.dojows.sumaws.beans.ServicioSumarWS")
public class ServicioSumarImpl implements ServicioSumarWS{

	@Override
	public int sumar(int a, int b) {
		return a + b;
	}

}
