package com.hackteam.songs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/songs")
public class SongsResource {
	
	@GET
	@Path("songlist")
	@Produces(MediaType.APPLICATION_JSON)
	public SongsResult getSongsList() {
		SongsService service = new SongsService("");
		service.generatePlaylist();
		return null;
	}
}
