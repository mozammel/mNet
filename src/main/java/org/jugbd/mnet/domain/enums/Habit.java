package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
public enum Habit {
    SMOKER("Smoker"),
    ALCOHOLIC("Alcoholic"),
    BETEL_NUT_CHEWER("Betel Nut Chewer"),
    OTHER("Other"),
    NONE("None");

    private String label;

    Habit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
