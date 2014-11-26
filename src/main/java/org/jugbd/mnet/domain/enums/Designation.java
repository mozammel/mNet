package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/18/14.
 */
public enum Designation {
    DOCTOR("Doctor"), NURSE("Nurse"), OPERATOR("Operator");

    String label;

    Designation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
