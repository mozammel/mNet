package org.jugbd.mnet.domain.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
public enum PictureInformationType {

    DAY_ONE("Day One"),

    PREOPERATIVE("Pre-operative"),

    PRE_OPERATION("Pre-operation"),

    POSTOPERATIVE("Post operative"),

    ON_DISCHARGE("On Discharge");

    private String label;

    PictureInformationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}

