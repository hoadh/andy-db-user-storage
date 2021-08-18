package com.codegym.userstorage.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static boolean check(String rawPassword, String phpPassword) {
        //Laravel bcrypt out
        String hash_php = phpPassword.replaceFirst("2y", "2a");
        return BCrypt.checkpw(rawPassword, hash_php);
    }
}
