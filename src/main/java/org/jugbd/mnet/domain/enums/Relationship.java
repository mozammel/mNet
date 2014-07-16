package org.jugbd.mnet.domain.enums;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
public enum Relationship {

    FATHER("Father"),
    MOTHER("Mother"),
    BROTHER("Brother"),
    SISTER("Sister"),
    HUSBAND("Husband"),
    WIFE("Wife"),
    SON("Son"),
    DAUGHTER("Daughter"),
    FRIEND("Friend"),
    OTHER("Other");

    private String label;

    Relationship(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
