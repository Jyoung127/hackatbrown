package com.hackteam.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResult {
	
	@XmlElement
	String authorizeUrl;
	
	public LoginResult() {}
	
	public LoginResult(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}
	
	public String getAuthorizeUrl() {
		return this.authorizeUrl;
	}
}
