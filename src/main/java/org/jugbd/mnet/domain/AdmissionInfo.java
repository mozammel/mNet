package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Raqibul Islam
 * @author Abdullah Al Mamun Oronno (mr.oronno@gmail.com)
 */
@Entity
public class AdmissionInfo extends PersistentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date admissionDate;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String bedNumber;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String unit;


}
