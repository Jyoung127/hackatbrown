package com.hackteam.processSongs;

import java.util.Objects;

public class Song {
	private final String _songID;
//	private final String _songName;
	
	public Song(String songID) {
		this._songID = songID;
//		this._songName = songName;
	}
	
	public String getSongID() {
		return _songID;
	}
	
//	public String getSongName() {
//		return _songName;
//	}
	
	@Override
	public String toString() {
		return this._songID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this._songID);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Song)) {
			return false;
		}
		Song other = (Song)o;
		return other.getSongID().equals(this._songID);
	}

}
