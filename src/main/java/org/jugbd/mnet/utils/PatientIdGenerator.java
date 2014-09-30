package org.jugbd.mnet.utils;

import org.jugbd.mnet.domain.Address;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/1/14.
 */
public class PatientIdGenerator {
    public static final int BASE_YEAR = 2014;
    private static final Random random = new Random();

    private static final String[] symbolPool = new String[]{
            "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H",
            "J", "K", "L", "M", "N", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    /* The last millisecond used by genFormIdSeq */
    private static int lastMillis = 0;
    private static int lastSecond = 0;

    /* Explicitly mentioning it although it's the default. We need WRITE lock. */
    public static String generate(Address address) {
        String divisionPref = address.getDivision().substring(0, 3).toUpperCase();
        String policeStationPrefix = address.getPoliceStation().substring(0, 4).toUpperCase();
        String seq = nextSequence(); // the sequence
        String main = divisionPref + "-" + policeStationPrefix + "-" + seq;
        return main + calculateCheckDigit(main);
    }

    private static String nextSequence() {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR) - BASE_YEAR;
        int m = cal.get(Calendar.MONTH) + 1; // In java January is 0
        int d = cal.get(Calendar.DAY_OF_MONTH); // starts with 1
        int s = cal.get(Calendar.HOUR_OF_DAY) * 3600
                + cal.get(Calendar.MINUTE) * 60
                + cal.get(Calendar.SECOND);
        int millis = cal.get(Calendar.MILLISECOND);
        int random = PatientIdGenerator.random.nextInt(3); // Generate 3 digits at max
        if (s <= lastSecond) {
            if (s < lastSecond) {
                s = lastSecond;
            }
            if (millis <= lastMillis) {
                millis = lastMillis + 1;
                if (millis >= 1024) {
                    // There are 86400 seconds/day. The seconds value is converted to base 32 and truncated to 4 digits.
                    // This gives a max of about 1 million. It's unlikely that our "s" will wrap around.
                    s++;
                    millis = 0;
                }
            }
        }
        lastSecond = s;
        lastMillis = millis;

        String y32 = base32(y, 0);
        String m32 = base32(m, 0);
        String d32 = base32(d, 0);
        String s32 = base32(s, 4);
        String millis32 = base32(millis, 2);
        String random3Digit = base32(random, 0); // max 3 digits
        return y32 + m32 + d32 + s32 + millis32 + random3Digit;
    }

    /**
     * Convert a base 10 integer to base32 string representation.
     *
     * @param n     The number to convert.
     * @param width Truncate to this width. 0 means no truncation.
     * @return The base32 number.
     */
    private static String base32(int n, int width) {
        StringBuilder val = new StringBuilder(10);
        int r;
        while (n > 0) {
            r = n % 32;
            n = n / 32;
            val.append(symbolPool[r]);
        }
        val.reverse();
        if (width == 0)
            return val.toString();
        StringBuilder v2 = new StringBuilder(10);
        for (int len = val.length(); len < width; len++) {
            v2.append(symbolPool[0]);
        }
        v2.append(val);
        return v2.toString();
    }

    private static String calculateCheckDigit(String formId) {
        char[] chars = formId.toCharArray();
        char hyphen = '-';
        int total = 0;
        int pos = 1;
        for (char c : chars) {
            if (c == hyphen) continue;
            total += (pos * Character.getNumericValue(c));
            pos++;
        }
        int check = total % 32;
        return base32(check, 0);
    }
}
