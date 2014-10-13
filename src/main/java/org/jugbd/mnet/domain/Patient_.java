package org.jugbd.mnet.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/13/14.
 */
@StaticMetamodel(Patient.class)
public class Patient_ {
    public static volatile SingularAttribute<Patient, String> name;
    public static volatile SingularAttribute<Patient, String> healthId;
    public static volatile SingularAttribute<Patient, String> contactNumber;
}
