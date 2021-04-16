package com.web.resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.web.service.PoliticiansByCountryService;
import com.web.data.Country;

@Path("/countries")
public class PoliticianByCountryResource {
	PoliticiansByCountryService service = new PoliticiansByCountryService();
	
	@Context
	UriInfo uriInfo;
	
	@POST
	@Path("/addCountry/{country}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addCountry(@PathParam("country") String country) {
		String text = service.addCountry(country);
		if(text == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + text;
		return Response.status(Response.Status.CREATED)
				.entity(text)
				.contentLocation(uri.resolve(newUri))
				.build();
	}
	
	
	@POST
	@Path("/addPolitican/{name}/{age}/{popularity}/{location}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addPolitican(@PathParam("name") String name, @PathParam("age") int age, @PathParam("popularity") int popularity, @PathParam("location") String location) {	
		int response = service.addPolitican(name, age, popularity, location);
		if(response == -1) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + name + "/" + age + "/" + popularity + "/" + location;
		return Response.status(Response.Status.CREATED)
				.entity(response)
				.contentLocation(uri.resolve(newUri))
				.build();
	}
	
	
	@GET
	@Path("/getPolitician/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPoliticianByCountry(@PathParam("country") String country) {
		String text = service.getPoliticianByCountry(country);
		if(text == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri())
				.rel("self")
				.type("application/xml")
				.build();
		return Response.status(Response.Status.OK)
				.entity(text)
				.links(link)
				.build();
	}

}
