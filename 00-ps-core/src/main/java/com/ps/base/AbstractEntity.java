package com.ps.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by iuliana.cosmina on 2/7/16.
 * Description:A template class which defines the common template for all entities in the project.
 */
@MappedSuperclass
@EqualsAndHashCode(exclude={"createdAt", "modifiedAt", "version"})
public abstract class AbstractEntity implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    @Getter @Setter
    protected Long id;

    /**
     * This field is used for auditory and logging purposes. It is populated by the system when an entity instance is created.
     */
    @JsonIgnore
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    protected Date createdAt;

    /**
     * This field is used for auditory and logging purposes. It is populated by the system when an entity instance is modified.
     */
    @JsonIgnore
    @Column(name = "MODIFIED_AT", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    protected Date modifiedAt;

    @JsonIgnore
    @Version
    public int version;

    /**
     * This constructor is required by JPA. All subclasses of this class will inherit this constructor.
     */
    protected AbstractEntity() {
        createdAt = new Date();
        modifiedAt = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("AbstractEntity[id='%d%n', createdAt='%s', modifiedAt='%s', version='%d%n']",
                id, sdf.format(createdAt), sdf.format(modifiedAt), version);

    }
}

