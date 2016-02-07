package com.hackteam.processSongs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {
	private String _userID;
	private Set<Song> _userSongs;
	
	public User(String userID) {
		this._userID = userID;
		this._userSongs = new HashSet<Song>();
	}
	
	public void addNewSong(Song song) {
		_userSongs.add(song);
	}
	
	public Set<Song> getSongList() {
		return _userSongs;
	}
	
	public String getUserID() {
		return _userID;
	}
}
