package br.bonnasys.vaccines.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //indicar que o hibernate deve gerar para a gente;
    @Column(length = 36)
    private String id;
    private String name;
    private String phone;
    private String email;
    private LocalDate birthdate;
    private OffsetDateTime createdAt; //yyyy-MM-ddTHH:mm:ss-Z 2024-01-11T20:59:00-03:00
    private OffsetDateTime updatedAt;
    @OneToMany(fetch = FetchType.EAGER) //mais profundo
    //@JoinColumn(foreignKey = @ForeignKey (name = "fk_vr_history"))
    private Set<VaccineRegistration> history;

    @PrePersist
    public void prePersist() {
        this.createdAt = OffsetDateTime.now();
    }
}
