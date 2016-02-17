package com.hackteam.processSongs;

import java.util.ArrayList;
import java.util.Set;

public class User {
	private String _userID;
	private ArrayList<Song> _userSongs;
	
	public User(String userID, ArrayList<Song> songList) {
		this._userID = userID;
		this._userSongs = songList;
	}
	
	public void addNewSong(Song song) {
		_userSongs.add(song);
	}
	
	public ArrayList<Song> getSongList() {
		return _userSongs;
	}
	
	public String getUserID() {
		return _userID;
	}
}
