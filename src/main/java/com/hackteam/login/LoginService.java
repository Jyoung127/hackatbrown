package com.hackteam.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import com.hackteam.processSongs.Song;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;

import database.DBClient;
import service.ApiClient;
import service.ApiServices;
import service.UserAuthentication;

public class LoginService {
	
	public String getAuth() {
		ApiClient client = new ApiClient();
		return UserAuthentication.getAuthUrl(client.getApi());
	}
	
	public void addSongs(String userCode) throws IOException, WebApiException {
		ApiClient client = new ApiClient();
		Api api = client.getApi();
		api = UserAuthentication.getAccessToken(api, userCode);
		
		Set<Song> newSongs = null;
		
		
		newSongs = ApiServices.getSongs(api);
		
		String userID = ApiServices.getUserID(api);
		
		ArrayList<Song> newSongsList = new ArrayList<Song>();
		newSongsList.addAll(newSongs);
		
		DBClient dbc = new DBClient();
		dbc.addToDB(newSongsList, userID);
	}
}
