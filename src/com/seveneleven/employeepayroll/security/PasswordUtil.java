package com.seveneleven.employeepayroll.security;

public class PasswordUtil {
	public static String hash(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
