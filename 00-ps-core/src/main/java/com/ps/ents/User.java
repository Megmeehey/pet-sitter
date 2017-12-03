package com.ps.ents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ps.base.AbstractEntity;
import com.ps.base.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@Entity
@Table(name="P_USER")
@SequenceGenerator(name = "seqGen", allocationSize = 1)
@NamedQueries({
        @NamedQuery(name=User.FIND_BY_USERNAME_EXACT, query = "FROM User u WHERE username= :un"),
        @NamedQuery(name=User.FIND_BY_USERNAME_LIKE, query = "FROM User u WHERE username LIKE :un")

})
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"firstName", "lastName", "password", "address", "email", "rating", "pets",
        "requests", "responses", "active"}, callSuper = true)
public class User extends AbstractEntity {
    public static final String FIND_BY_USERNAME_EXACT = "findByUsernameExact";
    public static final String FIND_BY_USERNAME_LIKE = "findByUsernameLike";


    /**
     * username = email
     */
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @Column(name="first_name")
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    @NotEmpty
    public String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    private String address;

    @NotEmpty
    @Column(unique = true)
    private String email;

    /***
     * Rating for a used is computed from reviews for a user
     */
    @NotNull
    @Column
    private Double rating;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Pet> pets = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade =  {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Request> requests = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade =  {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Response> responses = new HashSet<>();

    @Column
    private boolean active;

    public boolean addPet(Pet pet) {
        pet.setOwner(this);
        return pets.add(pet);
    }

    public boolean addRequest(Request request) {
        request.setUser(this);
        return requests.add(request);
    }

    public boolean addResponse(Response response) {
        response.setUser(this);
        return responses.add(response);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() + ";" + String.format("User[username='%s', firstName='%s', lastName='%s', email='%s'" +
                        " userType='%s', activeSince='%s', rating=id='%f%n']", getUsername(),
                getFirstName(), getLastName(), getEmail(), getUserType().toString(),sdf.format(createdAt), rating);

    }
}
