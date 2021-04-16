package com.web.resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.web.service.PoliticiansByCountryService;
import com.web.data.Country;

/**
 * Classe qui contient les méthodes permettant de gérer le service de l'application.
 * @file PoliticianByCountryResource.java
 * @author MANOUBI Farah, DENDOUNE Rayane
 * @version 1.0
 * @date 16/04/2021
 *
 */
@Path("/countries")
public class PoliticianByCountryResource {
	PoliticiansByCountryService service = new PoliticiansByCountryService();
	
	@Context
	UriInfo uriInfo;
	
	
	/**
	 * Fonction qui permet de savoir si un pays a bien été créé.
	 * Response addCountry(String country)
     * @param [in] country Nom du pays. (Type String)
     * @return Retourne une réponse.
     */
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
	
	/**
	 * Fonction qui permet de savoir si un politician a bien été créé.
	 * Response addPolitician(String name, int age, int popularity, String location)
     * @param [in] name Nom du politician. (Type String)
     * @param [in] age Age du politician. (Type int)
     * @param [in] popularity Nombre d'abonnés du politician. (Type int)
     * @param [in] location Pays du politician. (Type String)
     * @return Retourne une réponse.
     */
	@POST
	@Path("/addPolitican/{name}/{age}/{popularity}/{location}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addPolitician(@PathParam("name") String name, @PathParam("age") int age, @PathParam("popularity") int popularity, @PathParam("location") String location) {	
		int response = service.addPolitician(name, age, popularity, location);
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
	
	
	/**
	 * Fonction qui permet de connaitre les politicians en fonction d'un pays passé en paramètre.
	 * Response getPoliticianByCountry(String country)
     * @param [in] country Nom du pays. (Type String)
     * @return Retourne une réponse.
     */
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
