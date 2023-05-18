package com.demomic.gateway.impl.model;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;

public record User(String userName, String firstName, String lastName, List<String> roles) {

    public static User fromOidcUser(OidcUser oidcUser) {
        return new User(
                oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
                oidcUser.getClaimAsStringList("roles")
        );
    }
}
