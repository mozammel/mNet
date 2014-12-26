package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jugbd.mnet.domain.enums.Habit;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Entity
public class LifeStyle extends PersistentObject implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Size(max = 50)
    private String economicalStatus;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Habit habit;

    private String otherHabit;
    private String comment;

    @JsonIgnore
    @OneToOne(mappedBy = "lifeStyle")
    private Register register;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEconomicalStatus() {
        return economicalStatus;
    }

    public void setEconomicalStatus(String economicalStatus) {
        this.economicalStatus = economicalStatus;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public String getOtherHabit() {
        return otherHabit;
    }

    public void setOtherHabit(String otherHabit) {
        this.otherHabit = otherHabit;
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
