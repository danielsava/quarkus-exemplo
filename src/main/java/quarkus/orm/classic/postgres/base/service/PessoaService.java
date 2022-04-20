package quarkus.orm.classic.postgres.base.service;

import quarkus.orm.classic.postgres.base.model.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaService {


    @Inject
    EntityManager em;


    @Transactional
    public void create(String nome) {
        Pessoa p = Pessoa.of("Fulano");
        em.persist(p);
    }



}
