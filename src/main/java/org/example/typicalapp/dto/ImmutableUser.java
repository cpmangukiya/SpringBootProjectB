package org.example.typicalapp.dto;

import java.util.HashMap;
import java.util.HashSet;

public class ImmutableUser {
    private final String username;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;

    private ImmutableUser(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }

    public static class UserBuilder {

        private final String username;
        private final String password;
        private  String firstname;
        private String lastname;
        private String email;

        public UserBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public UserBuilder firstName(String firsname) {
            this.firstname = firsname;
            return this;
        }
        public UserBuilder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public ImmutableUser build() {
            return new ImmutableUser(this);
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();


        HashSet hashSet = new HashSet<String>();

    }
}
