package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;

public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }


    public static User createBasicUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastname");
        user.setPhoneNumber("123456123465");
        user.setCountry("TR");
        user.setEnabled(true);
        user.setDescription("a basic user");
        user.setProfileImageUrl("htt://image.com/image");

        return user;
    }
}
