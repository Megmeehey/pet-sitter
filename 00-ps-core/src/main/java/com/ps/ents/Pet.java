package com.ps.ents;

import com.ps.base.AbstractEntity;
import com.ps.base.PetType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@Entity
@Table(name = "P_PET")
@Getter @Setter
@EqualsAndHashCode(exclude = {"details"}, callSuper = true)
public class Pet extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private User owner;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "PET_TYPE")
    private PetType petType;

    @NotEmpty
    @Column
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    private Integer age;

    @Size(max = 500)
    @Column
    private String details;

    /**
     * The pet has a RFID microchip implant.
     */
    @NotEmpty
    @Column
    @Size(min = 10, max = 100)
    private String rfid;

    //required by JPA
    public Pet() {
        super();
        this.petType = PetType.OTHER;
        this.age = 0;
    }

    @Override
    public String toString() {
        return String.format("Pet[id='%04d', owner='%s', pet type='%s', pet name='%s', age='%04d']", id, owner == null ? ""
                : owner.getId(), petType.toString(), name, age);
    }
}
