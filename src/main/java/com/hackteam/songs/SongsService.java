package com.hackteam.songs;

import java.util.ArrayList;

import com.hackteam.processSongs.Song;

import database.DBClient;
import service.ApiServices;
import service.PlaylistMaker;

public class SongsService {
	
	private String userId;
	
	public SongsService(String userId) {
		this.userId = userId;
	}
	
	public SongsResult generatePlaylist() {
		//DBClient db = new DBClient();
//		ArrayList<Song> alos = db.makePlaylist();
//		System.out.println(ApiServices.currID);
//		PlaylistMaker.makePlaylist(alos);
		return null;
	}
}
