package com.hackteam.playlist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/playlist")
public class PlaylistResource {
	
	@GET
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public PlaylistResult getPlaylist() {
		PlaylistService service = new PlaylistService();
		return service.getResults();
	}
}
