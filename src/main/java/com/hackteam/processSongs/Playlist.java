package com.hackteam.processSongs;

import java.util.ArrayList;

public class Playlist {
	private ArrayList<Song> _playlist;
	private String _playlistID;
	private String _playlistName;
	
	public Playlist(String playlistid, String playlistName) {
		this._playlistID = playlistid;
		this._playlistName = playlistName;
		this._playlist = new ArrayList<Song>();
	}
	
	public void addSong(Song newSong) {
		this._playlist.add(newSong);
	}
	
	public String getPlayListID() {
		return _playlistID;
	}
	
	@Override
	public String toString() {
		return this._playlistName;
	}
}
