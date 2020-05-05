package com.github.n1ay.icey.data.model;

import java.util.HashSet;
import java.util.Set;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public static Set<Role> getUserRoleSet() {
        Set<Role> roleSet = new HashSet<>(1);
        roleSet.add(USER);
        return roleSet;
    }

    public static Set<Role> getAdminRoleSet() {
        Set<Role> roleSet = new HashSet<>(2);
        roleSet.add(ADMIN);
        roleSet.add(USER);
        return roleSet;
    }
}
