package com.codegym.userstorage.provider;

import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.*;
import org.keycloak.storage.adapter.AbstractUserAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AndyUser extends AbstractUserAdapter {
    private static final Logger log = LoggerFactory.getLogger(AndyUser.class);
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Set<AndyRole> roles;

    private AndyUser(KeycloakSession session, RealmModel realm,
                     ComponentModel storageProviderModel,
                     String username,
                     String email,
                     String firstName,
                     String lastName
    ) {
        super(session, realm, storageProviderModel);
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new HashSet<>();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> attributes = new MultivaluedHashMap<>();
        attributes.add(UserModel.USERNAME, getUsername());
        attributes.add(UserModel.EMAIL, getEmail());
        attributes.add(UserModel.FIRST_NAME, getFirstName());
        attributes.add(UserModel.LAST_NAME, getLastName());
        attributes.add(UserModel.EMAIL_VERIFIED, Boolean.TRUE.toString());
        return attributes;
    }

    static class Builder {
        private final KeycloakSession session;
        private final RealmModel realm;
        private final ComponentModel storageProviderModel;
        private String id;
        private String email;
        private String firstName;
        private String lastName;

        Builder(KeycloakSession session, RealmModel realm, ComponentModel storageProviderModel, String id) {
            this.session = session;
            this.realm = realm;
            this.storageProviderModel = storageProviderModel;
            this.id = id;
        }

        Builder email(String email) {
            this.email = email;
            return this;
        }

        Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        AndyUser build() {
            return new AndyUser(
                    session,
                    realm,
                    storageProviderModel,
                    id,
                    email,
                    firstName,
                    lastName
            );
        }
    }

    @Override
    public Set<RoleModel> getRoleMappings() {
        log.info("getRoleMappings()");
        Set<RoleModel> roles = super.getRoleMappings();
        roles.addAll(this.roles);
        return roles;
    }

    public void addRoles(Set<AndyRole> roles) {
        this.roles.addAll(roles);
    }

    @Override
    public void removeRequiredAction(String action) {
        log.info("removeRequiredAction(String {})", action);
        // Nothing here. Override just in order not to throw exception.
    }

    @Override
    public void addRequiredAction(String action) {
        log.info("addRequiredAction(String {})", action);
        // Nothing here. Override just in order not to throw exception.
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        log.info("removeRequiredAction(RequiredAction {})", action.name());
        // Nothing here. Override just in order not to throw exception.
    }

    @Override
    public void addRequiredAction(RequiredAction action) {
        log.info("addRequiredAction(RequiredAction {})", action.name());
        // Nothing here. Override just in order not to throw exception.
    }
}