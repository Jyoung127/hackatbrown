package com.hackteam.songs;

import database.DBClient;

public class SongsService {
	
	
	public SongsService() {
		
	}
	
	public SongsResult generatePlaylist() {
		DBClient db = new DBClient();
		return (new SongsResult(db.makePlaylist()));
	}
}
