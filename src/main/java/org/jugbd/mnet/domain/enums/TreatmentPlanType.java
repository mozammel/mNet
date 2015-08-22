package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/25/14.
 */
public enum TreatmentPlanType {
    CONSERVATIVE("Conservative"), OPERATIVE("Operative"), OTHER("Other");

    private String label;

    TreatmentPlanType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
