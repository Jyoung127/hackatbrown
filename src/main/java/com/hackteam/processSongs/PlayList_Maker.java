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
	
	private ArrayList<String> makeSongIDList(ArrayList<Song> songs) {
		ArrayList<String> toReturn = new ArrayList<String>();
		for (Song s : songs) {
			System.out.println("here" + s.getSongID());
			toReturn.add(s.getSongID());
		}
		return toReturn;
	}
	
	public ArrayList<String> generatePlaylist() {
		HashMap<String, Integer> universalList = new HashMap<String, Integer>();
		ArrayList<String> finalPlaylist = new ArrayList<String>();
		
		
		for (User user: _userList) {
			ArrayList<String> songIDList = makeSongIDList(user.getSongList());
			for (String songID : songIDList) {
				System.out.println("there" + songID);
				if (universalList.containsKey(songID)) {
					int counter = universalList.get(songID);
					universalList.put(songID, counter+1);
				} else {
					universalList.put(songID, 1);
				}
			}
		}
		
		for (String str: universalList.keySet()) {
			double counter = universalList.get(str);
			//System.out.println("counter of song "+song.getSongName()+"is: "+counter);
			//System.out.println("% of song in playlist is: "+counter/_userSize);
			if ( (counter/_userSize) >= _countRatio ) {
				System.out.println(String.format("song id here: %s", str));
				if (str.length() == 22 && !str.contains(" ")){
					finalPlaylist.add(str);
				}
			}
		}

		for (String songid: finalPlaylist) {
			System.out.print("final" + songid);
		}
		
		
		
		return finalPlaylist;
		
	}
}
