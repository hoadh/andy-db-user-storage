package com.codegym.userstorage.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static boolean check(String rawPassword, String phpHash) {
        String replacedPHPHash = phpHash.replaceFirst("2y", "2a");
        return BCrypt.checkpw(rawPassword, replacedPHPHash);
    }
}
