package com.hackteam.login;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.wrapper.spotify.exceptions.WebApiException;

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
	public Response authorize(@Context UriInfo rawCode) throws URISyntaxException {
		String queryStr = rawCode.getRequestUri().getQuery().substring(5);
		String code = queryStr.split("&")[0];
		java.net.URI location = null;
		try {
			(new LoginService()).addSongs(code);
			location = new java.net.URI("/playlist/confirmation/index.html");
			
			return Response.seeOther(location).build();
		} catch (URISyntaxException | IOException | WebApiException e) {
			e.printStackTrace();
		}
		return Response.temporaryRedirect(new java.net.URI("http://google.com")).build();
	}
}
