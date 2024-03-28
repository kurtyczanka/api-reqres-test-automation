package main;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class Auth {
    private String email;

    private String password;

    private int id;

    private String token;
}