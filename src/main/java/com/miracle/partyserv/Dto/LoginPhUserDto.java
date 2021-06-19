package com.miracle.partyserv.Dto;

import java.util.Objects;

public class LoginPhUserDto {

//    @NotNull(message = "The username field is empty")
    private String username;
//    @NotNull(message = "The password field is empty")
    private String password;

    public LoginPhUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginPhUserDto that = (LoginPhUserDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
