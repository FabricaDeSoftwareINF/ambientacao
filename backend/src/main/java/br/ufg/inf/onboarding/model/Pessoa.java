package br.ufg.inf.onboarding.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    private String nome;

    private String cpf;
}
