package smdb.app.domain;
import smdb.app.domain.Actor;

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
//@JsonFilter("product_filter")
@Entity
@Table(name = "FILMS", indexes = {@Index(columnList = "title")})
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", initialValue = 1, allocationSize = 1)
public class Film extends BaseEntity {
    //@NotNull
//    @Column(length = 30, nullable = false, unique = true)
//    private String serial;

    //@NotNull
    @Column(length = 50, nullable = false)
    private String title;

    //@NotNull
    @Column(length = 30, nullable = true, unique = false)
    private String year;


    @JsonManagedReference("actors")
    //@JsonBackReference("actors")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true, mappedBy = "lastname")
    private final Set<Actor> actors = new HashSet<>();
}
