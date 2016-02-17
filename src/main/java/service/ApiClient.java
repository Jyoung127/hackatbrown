package service;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.PlaylistTracksInformation;
import com.wrapper.spotify.models.SimplePlaylist;

public class ApiClient {
	

	/* Application details necessary to get an access token */
    private final String clientId = "6b263ec6c75a48e796d1657f76e3e9d9";
    private final String clientSecret = "04a2b4355a17405db356e94d24d3db04";
    private final String redirectUri = "http://localhost:8080/playlist/webapi/login/auth";
    
	final Api api;
	
	public ApiClient() {
		this.api = Api.builder()
				   .clientId(clientId)
				   .clientSecret(clientSecret)
				   .redirectURI(redirectUri)
				   .build();
	}
	
	public Api getApi() {
		return this.api;
	}
	
	public static void main(String[] args) {
		ApiClient testClient = new ApiClient();
		Api testApi = ClientCodeAuthentication.authenticate(testClient.getApi());
		Page<SimplePlaylist> page;
		try {
			page = testApi.getFeaturedPlaylists().build().get().getPlaylists();
			List<SimplePlaylist> list = page.getItems();
			ListIterator<SimplePlaylist> iter = list.listIterator();
			while (iter.hasNext()) {
				SimplePlaylist sp = iter.next();
				System.out.println(sp.getName());
			}
		} catch (IOException | WebApiException e) {
			System.out.println("Get failed");
			e.printStackTrace();
		}
		
	}
	

}
