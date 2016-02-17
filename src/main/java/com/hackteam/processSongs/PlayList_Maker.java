package com.hackteam.processSongs;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayList_Maker {
	private ArrayList<User> _userList;
	private double _countRatio;
	private int _userSize;
	
	public PlayList_Maker(ArrayList<User> userlist, double count_Ratio) {
		this._userList = userlist;
		_userSize = _userList.size();
		System.out.println("user size is: "+_userSize);
		this._countRatio = count_Ratio;
	}
	
	public ArrayList<Song> generatePlaylist() {
		HashMap<Song, Integer> universalList = new HashMap<Song, Integer>();
		ArrayList<Song> finalPlaylist = new ArrayList<Song>();
		
		for (User user: _userList) {
			for (Song song : user.getSongList()) {
				if (universalList.containsKey(song)) {
					int counter = universalList.get(song);
					universalList.put(song, counter+1);
				} else {
					universalList.put(song, 1);
				}
			}
		}
		
		for (Song song: universalList.keySet()) {
			double counter = universalList.get(song);
			System.out.println("counter of song "+song.getSongName()+"is: "+counter);
			System.out.println("% of song in playlist is: "+counter/_userSize);
			if ( (counter/_userSize) >= _countRatio ) {
				finalPlaylist.add(song);
			}
		}

//		for (String songid: finalPlaylist) {
//			System.out.print(songid);
//		}
		
		return finalPlaylist;
		
	}
}
