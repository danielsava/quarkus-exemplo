package quarkus.reactive.crud;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
@NamedQuery(name = "Carros.obterTodos", query = "select c from Carro c order by c.nome")
public class Carro extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String nome;

}
