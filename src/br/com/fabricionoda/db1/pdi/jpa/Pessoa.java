package br.com.fabricionoda.db1.pdi.jpa;

import javax.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }
}
