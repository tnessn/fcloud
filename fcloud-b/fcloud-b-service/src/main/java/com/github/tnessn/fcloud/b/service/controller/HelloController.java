/**
 * 
 */
package com.github.tnessn.fcloud.b.service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangjinfeng
 */
@RestController
public class HelloController {


	@GetMapping("/hello")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String hello(Authentication authentication) {
		authentication.getCredentials();
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		String token = details.getTokenValue();
		return token;
	}

}
