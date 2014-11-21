package org.jugbd.mnet.domain.enums;

/**
 * Created by User on 11/18/2014.
 */
public enum Occupation {
    DAY_LABOUR("Day Labour"), STUDENT("Student"), PROFESSIONAL("Professional"), FARMER("Farmer"), HOUSEWIFE("Housewife"), OTHER("Other");

    private String label;

    Occupation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
