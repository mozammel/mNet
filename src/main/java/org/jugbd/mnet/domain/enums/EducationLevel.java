package org.jugbd.mnet.domain.enums;

/**
 * Created by User on 11/20/2014.
 */
public enum EducationLevel {
    ILLITERATE("Illiterate"), BELLOW_V("Bellow V"), VIII("VIII"), SSC("SSC"), HSC("HSC"), GRADUATE("Graduate"), OTHER("Other");
    private String label;

    EducationLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
