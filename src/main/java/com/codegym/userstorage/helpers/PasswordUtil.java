package com.codegym.userstorage.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    private final static String PHP_HASH_REFIX  = "2y";
    private final static String JAVA_HASH_REFIX = "2a";

    public static boolean check(String rawPassword, String phpHash) {
        String replacedPHPHash = phpHash.replaceFirst(PHP_HASH_REFIX, JAVA_HASH_REFIX);
        return BCrypt.checkpw(rawPassword, replacedPHPHash);
    }

    public static String convertToPHPHash(String rawPassword) {
        String javaHash = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        return javaHash.replaceFirst(JAVA_HASH_REFIX, PHP_HASH_REFIX);
    }
}
