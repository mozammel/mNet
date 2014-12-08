package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
public enum ChildBornWith {
    CLEFT_DEFORMITY("Cleft Deformity"), HAND_ANOMALY("Hand Anomaly"), EAR_DEFORMITY("Ear Deformity"), OTHER("Other");

    private String label;

    ChildBornWith(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
