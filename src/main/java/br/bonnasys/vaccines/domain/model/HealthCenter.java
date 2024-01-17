package br.bonnasys.vaccines.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "health_center")
public class HealthCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //indicar que o hibernate deve gerar para a gente;
    @Column(length = 36) //uuid
    private String id;
    private String name;
    private String address;
    private String state;
    private String neighborhood;

    @ElementCollection
    @CollectionTable(name = "vaccine_stock",
            joinColumns = @JoinColumn(name = "health_center_id", foreignKey = @ForeignKey(name = "health_center_hc_id")))
    @MapKeyJoinColumn(name = "vaccine_id", foreignKey = @ForeignKey(name = "health_center_vaccine_id"))
    @Column(name = "amount")
    private Map<Vaccine, Integer> stock;

    //centro de saude -> estoque{vacina, quantidade}

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
