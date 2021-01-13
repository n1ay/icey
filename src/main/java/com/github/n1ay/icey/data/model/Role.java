package com.github.n1ay.icey.data.model;

import com.google.common.collect.ImmutableSet;

public enum Role {
    USER,
    ADMIN;

    public boolean isAdmin() {
        return this == ADMIN;
    }

    public boolean isUser() {
        return ImmutableSet.of(USER, ADMIN).contains(this);
    }
}
