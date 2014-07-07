package org.jugbd.mnet.domain;

/**
 * @author raqibul
 * @since 7/1/14 2:19 PM
 */
public enum Relationship {

    FA("Father"),
    MO("Mother"),
    BR("Brother"),
    SI("Sister"),
    HU("Husband"),
    WI("Wife"),
    SO("Son"),
    DA("Daughter"),
    FR("Friend"),
    OT("Other");

    private String label;

    Relationship(String label) {
        this.label = label;
    }
}
