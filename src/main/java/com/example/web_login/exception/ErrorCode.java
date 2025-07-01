package com.example.web_login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    KEY_INVALID(1001,"Invalid message key"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003,"Username must be between 4 and 50 characters"),
    PASSWORD_INVALID(1004,"Password must be at least 6 characters"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated")
    ;

    private int code;
    private String message;
}
