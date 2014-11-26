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

    private static String elegibleChars = "ABDEFGHJKLMRSTUVWXYabdefhjkmnrstuvwxy23456789";

    public static String generateRandomString(int stringLength) {

        char[] chars = elegibleChars.toCharArray();
        StringBuffer finalString = new StringBuffer();

        for (int i = 0; i < stringLength; i++) {
            double randomValue = Math.random();
            int randomIndex = (int) Math.round(randomValue * (chars.length - 1));
            char characterToShow = chars[randomIndex];
            finalString.append(characterToShow);
        }

        return finalString.toString();
    }
}
