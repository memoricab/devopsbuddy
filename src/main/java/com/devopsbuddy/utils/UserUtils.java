package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.web.contollers.ForgotMyPasswordController;
import com.devopsbuddy.web.domain.frontend.BasicAccountPayload;

import javax.servlet.http.HttpServletRequest;

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

    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {
        String passwordResetUrl =
                request.getScheme() +
                        "://" +
                        request.getServerName() +
                        ":" +
                        request.getServerPort() +
                        request.getContextPath() +
                        ForgotMyPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token=" +
                        token;

        return passwordResetUrl;
    }

    public static <T extends BasicAccountPayload> User fromWebUserToDomainUser(T frontendPayload) {
        User user = new User();
        user.setUsername(frontendPayload.getUsername());
        user.setPassword(frontendPayload.getPassword());
        user.setFirstName(frontendPayload.getFirstName());
        user.setLastName(frontendPayload.getLastName());
        user.setEmail(frontendPayload.getEmail());
        user.setCountry(frontendPayload.getCountry());
        user.setPhoneNumber(frontendPayload.getPhoneNumber());
        user.setEnabled(true);
        user.setDescription(frontendPayload.getDescription());

        return user;
    }
}
