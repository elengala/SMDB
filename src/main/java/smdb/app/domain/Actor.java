package smdb.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACTORS", indexes = {@Index(columnList = "lastname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Actor  extends BaseEntity {
    //@NotNull(message = "Actor's firstname should be present.")
    @Column(length = 20, nullable = false)
    private String firstname;

    //@NotNull(message = "Actor's firstname should be present.")
    @Column(length = 30, nullable = false)
    private String lastname;

    //@Min(value = 16, message = "")
    //@Max(value = 100, message = "")
    private Integer age;

    @JsonManagedReference("films")
    //@JsonBackReference("films")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "title")
    private final Set<Film> films = new HashSet<>();

    public String getlastname() {
        return lastname;
    }
}

