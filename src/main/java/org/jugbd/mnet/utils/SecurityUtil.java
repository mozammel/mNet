package org.jugbd.mnet.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
public class SecurityUtil {
    private static final Logger log = LoggerFactory.getLogger(SecurityUtil.class);

    public static String encrypt(String password, String salt) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String saltedPassword = salt + password;
            byte[] saltedPasswordBytes = saltedPassword.getBytes();

            md.update(saltedPasswordBytes);
            byte[] encryptedPassword = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte anEncryptedPassword : encryptedPassword) {
                hexString.append(Integer.toHexString(0xFF & anEncryptedPassword));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("Algorithm: SHA-256 does not exists");
            return password;
        }
    }
}

