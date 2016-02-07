package com.hackteam.login;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/login")
public class LoginResource {
	
	@GET
	@Path("url")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResult getLogin() {
		return new LoginResult((new LoginService()).getAuth());
	}
	
	@GET
	@Path("/auth")
	public Response authorize(@Context UriInfo rawCode) {
		String code = rawCode.getRequestUri().getQuery().substring(5);
		System.out.println(code);
		java.net.URI location = null;
		try {
			location = new java.net.URI("/" + code);
			return Response.temporaryRedirect(location).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.noContent().build();
	}
}
