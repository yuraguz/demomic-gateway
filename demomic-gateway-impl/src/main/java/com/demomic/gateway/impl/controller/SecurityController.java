package com.demomic.gateway.impl.controller;

import com.demomic.gateway.impl.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityController {

    private final OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserToken(Authentication authentication) {
        var oidcUser = (OidcUser) authentication.getPrincipal();
        return User.fromOidcUser(oidcUser);
    }

    @RequestMapping(value = "/oidcUser", method = RequestMethod.GET)
    public User getUserToken(@AuthenticationPrincipal OidcUser oidcUser) {
        return User.fromOidcUser(oidcUser);
    }
}
