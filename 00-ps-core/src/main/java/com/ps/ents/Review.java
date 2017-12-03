package com.ps.ents;

import com.ps.base.AbstractEntity;
import com.ps.base.ReviewGrade;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
@Entity
@Table(name="P_REVIEW")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"details"}, callSuper = true)
public class Review extends AbstractEntity {

    @ManyToOne
    private Request request;

    @ManyToOne
    private Response response;

    @NotEmpty
    @Enumerated(EnumType.ORDINAL)
    private ReviewGrade grade;

    @Size(max = 500)
    @NotEmpty
    private String details;

    @Override
    public String toString() {
        return String.format("Review[request_id='%04d', response_id='%04d', grade='%s', details='%s']",
                request.getId(), response.getId(), grade.toString(), details);
    }
}
