package com.example.security.domain.enums;

import lombok.Getter;

@Getter
public enum Profile {
    ADMIN(0,"ROLE_ADMIN"),
    USER(1,"ROLE_USER");

    private int code;
    private String description;

    private Profile(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
