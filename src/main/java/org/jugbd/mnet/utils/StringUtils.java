package org.jugbd.mnet.utils;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/13/14.
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.trim().length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
