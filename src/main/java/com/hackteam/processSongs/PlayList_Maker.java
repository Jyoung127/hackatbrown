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
	
	public ArrayList<String> generatePlaylist() {
		HashMap<String, Integer> universalList = new HashMap<String, Integer>();
		ArrayList<String> finalPlaylist = new ArrayList<String>();
		
		for (User user: _userList) {
			for (Song song : user.getSongList()) {
				String songid = song.getSongID();
				if (universalList.containsKey(songid)) {
					int counter = universalList.get(songid);
					universalList.put(songid, counter+1);
				} else {
					universalList.put(songid, 1);
				}
			}
		}
		
		for (String songid: universalList.keySet()) {
			double counter = universalList.get(songid);
			System.out.println("counter of song "+songid+"is: "+counter);
			System.out.println("% of song in playlist is: "+counter/_userSize);
			if ( (counter/_userSize) >= _countRatio ) {
				finalPlaylist.add(songid);
			}
		}
		
		for (String songid: finalPlaylist) {
			System.out.print(songid);
		}
		
		return finalPlaylist;
		
	}
}
