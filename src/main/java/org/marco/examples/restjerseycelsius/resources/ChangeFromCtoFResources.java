package org.marco.examples.restjerseycelsius.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

//localhost:8080/RestJerseyExample/ToFahrenheitService
//http://localhost:8080/restjerseycelsius/webapi/ToFahrenheitService

@Path("/ToFahrenheitService")
public class ChangeFromCtoFResources {

    //Default Get. No parameters passed in.
    //localhost:8080/RestJerseyExample/ToFahrenheitService
	@GET
	@Produces("application/xml")
	public String ConvertCtoF() {
		//Default 
		Double celsius = 36.5;
		Double fahrenheit = ((celsius * 9) / 5) + 32;

		
		return getReturnString(fahrenheit, celsius);
	}
	
	   //Default Get. No parameters passed in.
    //localhost:8080/RestJerseyExample/ToFahrenheitService
    @Path("{celsius}")
	@GET 
    @Produces("application/xml")
    public String ConvertCtoF(@PathParam("celsius") Double celsius) {
        //Default 
        Double fahrenheit = ((celsius * 9) / 5) + 32;
        return getReturnString(fahrenheit, celsius);
    }
	
	
	
	public String getReturnString(Double temperatureF, Double temperatureC) {
		
		String result = 
		     "@Produces(\"application/xml\") "
		     + "Output: \n\nC to F "
		     + "Converter Output: \n\n" 
		     + temperatureF;
		
		return    "<ctofservice>" + "<celsius>" + temperatureC + "</celsius>" +
		            "<ctofoutput>" + result + "</ctofoutput>" + 
		           "</ctofservice>";
	}
		
}
