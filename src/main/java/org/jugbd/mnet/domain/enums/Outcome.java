package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
public enum Outcome {
    EVENTFUL("Eventful"), UNEVENTFUL("Uneventful"), DEATH("Death"), OTHER("Other");

    private String label;

    Outcome(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
