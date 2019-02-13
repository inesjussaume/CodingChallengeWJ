package com.workjam.objects.User;


import java.util.UUID;

public class Employee implements User {

    private UUID uuid;
    private String name;
    private boolean active;

    public Employee() {
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
    public void setName(String firstName) {
        this.name = firstName;
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
        return Permission.EMPLOYEE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Id: ").append(uuid)
            .append(", Name: ").append(name)
            .append(", IsActive: ").append(active)
            .append(", Permission: ").append(getPermission());
        return sb.toString();
    }
}
