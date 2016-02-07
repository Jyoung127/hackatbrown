package service;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import com.wrapper.spotify.models.User;

public class CurrentUser {
	private final String code;
	private final Api api;
	
	public CurrentUser(String code, Api api) {
		this.code = code;
		this.api = api;
	}

	void auth() {
	    try {
	
	      /* Retrieve an access token */
	      final AuthorizationCodeCredentials authorizationCodeCredentials = api.authorizationCodeGrant(code).build().get();
	
	      /* The token response contains a refresh token, an accesstoken, and some other things.
	       * We only need the access token to retrieve the user's information.
	       */
	      final String accessToken = authorizationCodeCredentials.getAccessToken();
	
	      /* Retrieve information about the user.
	      * The amount of information that is set on the User object depends on the scopes that
	      * the user has allowed the application to read.
	      * Read about which scopes that are available on
	      * https://developer.spotify.com/spotify-web-api/get-users-profile/
	      */
	      final User currentUser = api.getMe().accessToken(accessToken).build().get();
	
	      /* Use the information about the user */
	      System.out.println("URI to currently logged in user is: " + currentUser.getUri());
	      System.out.println("The currently logged in user comes from: " + currentUser.getCountry());
	      System.out.println("You can reach this user at: " + currentUser.getEmail());
	
	    } catch (Exception e) {
	      System.out.println("Something went wrong.");
	    }
	}
}
