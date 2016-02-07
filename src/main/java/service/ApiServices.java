package service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hackteam.processSongs.Song;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.CurrentUserRequest;
import com.wrapper.spotify.methods.PlaylistTracksRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.models.SimplePlaylist;
import com.wrapper.spotify.models.Track;
import com.wrapper.spotify.models.User;

public class ApiServices {
	
	public static String getUserID(Api api) {
		CurrentUserRequest cur = api.getMe().build();
		try {
			User user = cur.get();
			return user.getId();
		} catch (IOException | WebApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}
	
	public static Set<Song> getSongs(Api api) {
		String userID = ApiServices.getUserID(api);
		System.out.println(userID);
		
		UserPlaylistsRequest upr = 
				api.getPlaylistsForUser(userID).build();
		
		Set<Song> toReturn = new HashSet<Song>();
		
		Page<SimplePlaylist> playlistsPage = null;
		try {
			playlistsPage = upr.get();
			for (SimplePlaylist s : playlistsPage.getItems()) {
				System.out.println(s.getName());
			}
		} catch (IOException | WebApiException e1) {
			System.out.println("Playlists request failed");
			e1.printStackTrace();
		}
		
		System.out.println(playlistsPage.getHref());
		
		for (SimplePlaylist playlist : playlistsPage.getItems()) {
			String playlistID = playlist.getId();
			System.out.println(playlistID);
			PlaylistTracksRequest ptr = api.getPlaylistTracks(userID, playlistID).build();
			
			Page<PlaylistTrack> trackPage = null;
			try {
				trackPage = ptr.get();
			} catch (IOException | WebApiException | IllegalArgumentException e) {
				System.out.println("Playlists track request failed");
				e.printStackTrace();
			}
			
			if (trackPage != null) {
				System.out.println("success");
				List<PlaylistTrack> trackList  = trackPage.getItems();
				
				
				for (PlaylistTrack playlistTrack : trackList) {
					Track track = playlistTrack.getTrack();
					Song toAdd = new Song(track.getId(), track.getName());
					toReturn.add(toAdd);
				}
			} else {
				System.out.println("trackpage null");
			}
		}
		
		return toReturn;
	}
}
