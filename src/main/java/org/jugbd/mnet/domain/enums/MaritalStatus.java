package org.jugbd.mnet.domain.enums;

/**
 * Created by User on 11/18/2014.
 */
public enum MaritalStatus {
    MARRIED("Married "), DIVORCED("Divorced"), WIDOWED("Widowed"), SEPARATED("Separated"), SINGLE("Single"), OTHER("Other");

    private String label;

    MaritalStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
