package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hackteam.processSongs.Song;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.AddTrackToPlaylistRequest;
import com.wrapper.spotify.methods.PlaylistCreationRequest;
import com.wrapper.spotify.models.Playlist;

public class PlaylistMaker {
	
	private static String convertToUri(String songid) {
		return String.format("spotify:track:%s", songid);
	}
	
	public static void makePlaylist(Api api, List<String> playlist, String userId) {
		Playlist p = null;
		
		try {
			PlaylistCreationRequest pcr = 
					api.createPlaylist(userId, "WayvePool Playlist")
					.publicAccess(true).build();
			p = pcr.get();
			System.out.println("success");
		} catch (IOException | WebApiException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		
		List<String> aloURI = new ArrayList<String>();
		for (String s : playlist) {
			String currUri = convertToUri(s);
			if (currUri.trim().length() == 36 && !currUri.trim().contains(" ")) {
				aloURI.add(currUri);
				System.out.println(currUri);
			}
		}
		try {
			if (p != null) {
				AddTrackToPlaylistRequest req = 
						api.addTracksToPlaylist(userId, p.getId(), aloURI)
						.position(0).build();
				req.get();
			}
		} catch (IOException | WebApiException | NullPointerException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
