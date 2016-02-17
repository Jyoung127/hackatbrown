package com.hackteam.songs;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.hackteam.processSongs.Song;

@XmlRootElement
public class SongsResult {

	@XmlElement
	Song[] songList;
	
	public SongsResult() {}
	
	public SongsResult(Song[] songList) {
		this.songList = songList;
	}
	
	public Song[] getSongList() {
		return this.songList;
	}
}
