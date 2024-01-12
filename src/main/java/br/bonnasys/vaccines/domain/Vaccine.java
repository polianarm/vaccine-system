package br.bonnasys.vaccines.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
@Getter
@Setter
@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //indicar que o hibernate deve gerar para a gente;
    @Column(length = 36)
    private String id;
    private String name;
    private String producer;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;

}
