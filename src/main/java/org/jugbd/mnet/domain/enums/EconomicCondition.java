package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
public enum EconomicCondition {
    LOWER_CLASS("Lower class"), MIDDLE_CLASS("Middle Class"), HIGHER_CLASS("Middle Class");

    private String label;

    EconomicCondition(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
