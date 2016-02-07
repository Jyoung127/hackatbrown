package com.hackteam.playlist;

public class PlaylistService {
	
	public PlaylistService() {
		
	}
	
	public PlaylistResult getResults() {
		String[] resultList = {"SongID 1","SongID 2", "SongID 3"};
		return new PlaylistResult(resultList);
	}
}
