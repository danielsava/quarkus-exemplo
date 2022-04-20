package quarkus.orm.reactive;

//@Entity
//@Table(name = "carro")
//@NamedQuery(name = "Carros.obterTodos", query = "select c from Carro c order by c.nome")
public class Carro //extends PanacheEntity
{

    //@Column(length = 40, unique = true)
    public String nome;

}
