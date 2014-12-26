package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
public enum RequiredNotRequired {
    REQUIRED("Required"), NOT_REQUIRED("Not Required");

    private final String label;

    RequiredNotRequired(String value) {
        this.label = value;
    }

    public String getLabel() {
        return label;
    }
}
