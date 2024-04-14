package org.example.service;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static final Map<String, User> loginToProfile = new HashMap<>() {{
        put("vladi", new User("vladi", "qwerty", "vladislav.fazylov04@gmail.com"));
    }};

    public static void addNewUser(User userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public static User getUserByLogin(String login) {
        return loginToProfile.get(login);
    }
}
