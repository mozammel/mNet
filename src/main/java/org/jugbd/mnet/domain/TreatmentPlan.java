package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jugbd.mnet.domain.enums.TreatmentPlanType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rokonoid on 12/25/14.
 */

@Entity
public class TreatmentPlan extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private TreatmentPlanType treatmentPlanType;

    @Size(max = 500)
    private String typeOfConservativeTreatment;

    private Boolean stsgOrFtsg;
    private Boolean flapPedicled;
    private Boolean freeFlap;
    private Boolean tissueExpansion;
    private Boolean fasciotomyOrEscharotomy;
    private Boolean implantInsertion;
    private Boolean repairReconstructionPart;

    @Size(max = 1000)
    private String comment;

    @JsonIgnore
    @OneToOne(mappedBy = "treatmentPlan")
    private Register register;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TreatmentPlanType getTreatmentPlanType() {
        return treatmentPlanType;
    }

    public void setTreatmentPlanType(TreatmentPlanType treatmentPlanType) {
        this.treatmentPlanType = treatmentPlanType;
    }

    public String getTypeOfConservativeTreatment() {
        return typeOfConservativeTreatment;
    }

    public TreatmentPlan setTypeOfConservativeTreatment(String typeOfConservativeTreatment) {
        this.typeOfConservativeTreatment = typeOfConservativeTreatment;
        return this;
    }

    public Boolean getStsgOrFtsg() {
        return stsgOrFtsg;
    }

    public void setStsgOrFtsg(Boolean stsgOrFtsg) {
        this.stsgOrFtsg = stsgOrFtsg;
    }

    public Boolean getFlapPedicled() {
        return flapPedicled;
    }

    public void setFlapPedicled(Boolean flapPedicled) {
        this.flapPedicled = flapPedicled;
    }

    public Boolean getFreeFlap() {
        return freeFlap;
    }

    public void setFreeFlap(Boolean freeFlap) {
        this.freeFlap = freeFlap;
    }

    public Boolean getTissueExpansion() {
        return tissueExpansion;
    }

    public void setTissueExpansion(Boolean tissueExpansion) {
        this.tissueExpansion = tissueExpansion;
    }

    public Boolean getFasciotomyOrEscharotomy() {
        return fasciotomyOrEscharotomy;
    }

    public void setFasciotomyOrEscharotomy(Boolean fasciotomyOrEscharotomy) {
        this.fasciotomyOrEscharotomy = fasciotomyOrEscharotomy;
    }

    public Boolean getImplantInsertion() {
        return implantInsertion;
    }

    public void setImplantInsertion(Boolean implantInsertion) {
        this.implantInsertion = implantInsertion;
    }

    public Boolean getRepairReconstructionPart() {
        return repairReconstructionPart;
    }

    public void setRepairReconstructionPart(Boolean repairReconstructionPart) {
        this.repairReconstructionPart = repairReconstructionPart;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
