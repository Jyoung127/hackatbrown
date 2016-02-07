package com.hackteam.playlist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaylistResult {
	
	@XmlElement
	String[] playlist;
	
	public PlaylistResult() {}
	
	public PlaylistResult(String[] playlist) {
		this.playlist = playlist;
	}
	
	public String[] getPlaylist() {
		return this.playlist;
	}
}
