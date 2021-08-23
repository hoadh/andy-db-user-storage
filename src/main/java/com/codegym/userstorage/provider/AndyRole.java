package com.codegym.userstorage.provider;

import org.keycloak.models.ClientModel;
import org.keycloak.models.RoleContainerModel;
import org.keycloak.models.RoleModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AndyRole implements RoleModel {

    private final String id;
    private final String name;
    private final String description;
    private final ClientModel clientModel;

    public AndyRole(String id, String name, String description, ClientModel clientModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clientModel = clientModel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void addCompositeRole(RoleModel role) {}

    @Override
    public void removeCompositeRole(RoleModel role) {}

    @Override
    public Stream<RoleModel> getCompositesStream() {
        return Stream.empty();
    }

    @Override
    public boolean isClientRole() {
        return false;
    }

    @Override
    public String getContainerId() {
        return this.clientModel.getId();
    }

    @Override
    public RoleContainerModel getContainer() {
        return this.clientModel;
    }

    @Override
    public boolean hasRole(RoleModel role) {
        return false;
    }

    @Override
    public void setSingleAttribute(String name, String value) {

    }

    @Override
    public void setAttribute(String name, List<String> values) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Stream<String> getAttributeStream(String name) {
        return Stream.empty();
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        return new HashMap<>();
    }
}
