package org.jugbd.mnet.domain.enums;

/**
 * Created by rokonoid on 12/24/14.
 */
public enum Ward {
    CHILD("Child"), MALE("Male"), FEMALE("Female"), HDU("HDU"), ICU("ICU"), OTHER("Other");

    private String label;

    Ward(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
