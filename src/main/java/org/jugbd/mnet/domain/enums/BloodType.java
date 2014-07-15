package org.jugbd.mnet.domain.enums;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
public enum BloodType {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("A+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String value;

    BloodType(String value) {
        this.value = value;
    }
}
