package com.ps.ents;

import com.ps.base.AbstractEntity;
import com.ps.base.ResponseStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@Entity
@Table(name="P_RESPONSE")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"details", "responseStatus"}, callSuper = true)
public class Response extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "REQUEST_ID", nullable = false)
    private Request request;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "RESPONSE_STATUS")
    private ResponseStatus responseStatus;

    @Size(max = 500)
    @NotEmpty
    private String details;

    @Override
    public String toString() {
        return String.format("Request[id='%04d', user='%s', request='%s', responseStatus='%s']",
                id, user == null ? "" : user.getId(), request == null ? "" : request.getId(), responseStatus);
    }
}
