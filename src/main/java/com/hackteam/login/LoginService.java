package com.hackteam.login;

import service.ApiClient;
import service.UserAuthentication;

public class LoginService {
	
	public String getAuth() {
		ApiClient client = new ApiClient();
		return UserAuthentication.getAuthUrl(client.getApi());
	}
}
