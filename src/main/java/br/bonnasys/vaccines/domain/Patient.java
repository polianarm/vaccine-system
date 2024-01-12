package br.bonnasys.vaccines.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private OffsetDateTime createAt; //yyyy-MM-ddTHH:mm:ss-Z 2024-01-11T20:59:00-03:00
    private OffsetDateTime updateAt;
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey (name = "fk_vr_history"))
    private Set<VaccineRegistration> history;
}
