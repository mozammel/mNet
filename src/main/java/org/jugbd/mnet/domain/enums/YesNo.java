package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
public enum YesNo {
    YES("Yes"), No("No");

    private final String label;

    YesNo(String value) {
        this.label = value;
    }

    public String getLabel() {
        return label;
    }
}
