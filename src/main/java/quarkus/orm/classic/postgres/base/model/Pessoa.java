package quarkus.orm.classic.postgres.base.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "pessoa")
@NamedQuery(name = "Pessoa.obterTodos", query = "select p from Pessoa p order by p.nome")
public class Pessoa //extends PanacheEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
    //@GeneratedValue(generator = "giftSeq")
    public Long id;

    @Column(length = 40, unique = true)
    public String nome;


    public LocalDateTime dataHora;


    public Pessoa() { }

    public Pessoa(String nome, LocalDateTime dataHora) {
        this.nome = nome;
        this.dataHora = dataHora;
    }

    public static Pessoa of(String nome) {
        return new Pessoa(nome, LocalDateTime.now());
    }


}
