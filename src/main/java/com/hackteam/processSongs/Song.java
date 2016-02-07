package com.hackteam.processSongs;

public class Song {
	private String _songID;
	private String _songName;
	
	public Song(String songID, String songName) {
		this._songID = songID;
		this._songName = songName;
	}
	
	public String getSongID() {
		return _songID;
	}
	
	public String getSongName() {
		return _songName;
	}
	
	@Override
	public String toString() {
		return this._songName;
	}

}
