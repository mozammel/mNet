package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
public enum MenstrualCycle {
    REGULAR("Regular"), IRREGULAR("Irregular");

    private String label;

    MenstrualCycle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
