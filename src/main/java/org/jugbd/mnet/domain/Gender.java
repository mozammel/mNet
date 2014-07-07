package org.jugbd.mnet.domain;

/**
 * @author raqibul
 * @since 7/1/14 2:13 PM
 */
public enum Gender {

    M("Male"),
    F("Female"),
    O("Other");

    private String label;

    Gender(String label) {
        this.label = label;
    }
}
