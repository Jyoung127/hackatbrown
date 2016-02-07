package service;

import java.util.Arrays;
import java.util.List;

import com.wrapper.spotify.Api;

public class UserAuthentication {
	
	public static String getAuthUrl(Api api) {
		/* Set the necessary scopes that the application will need from the user */
		final List<String> scopes = Arrays.asList("user-read-private", "user-read-email");

		/* Set a state. This is used to prevent cross site request forgeries. */
		final String state = "someExpectedStateString";

		return api.createAuthorizeURL(scopes, state);
	}
}
