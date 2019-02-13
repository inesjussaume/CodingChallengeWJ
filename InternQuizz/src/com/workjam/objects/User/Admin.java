package com.workjam.objects.User;


import com.sun.tools.javac.util.List;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Admin implements User {

    private UUID uuid;
    private String name;
    private boolean active;
    private Set<Manager> managerList = new HashSet<>();

    public Admin() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Permission getPermission() {
        return Permission.ADMIN;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Id: ").append(uuid)
            .append(", Name: ").append(name)
            .append(", IsActive: ").append(active)
            .append(", Permission: ").append(getPermission())
            // Tutorial on Java 8 lambdas/streams are here in case you're interested: https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
            // Who knows... you might be able to reuse it for the filter part ;)
            .append(", Tyrannizes: ").append(managerList.stream().map(User::getUuid).collect(Collectors.toSet()).toString());
        return sb.toString();
    }

    public Set<Manager> getManagerList() {
        return managerList;
    }

    public void addManagers(Manager... managers) {
        managerList.addAll(List.from(managers));
    }
}
