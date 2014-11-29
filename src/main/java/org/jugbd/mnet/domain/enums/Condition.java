package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
public enum Condition {
    SUPERFICIAL("Superficial"), DEEP("Deep"), MIXED("Deep");

    private String label;

    Condition(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
