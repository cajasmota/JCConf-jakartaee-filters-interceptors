package com.cajasmota.jcconf.users;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class UsersService {

    @PersistenceContext
    private EntityManager db;

    public User byEmail(String email) {
        User user = null;

        try {
            user = db.createNamedQuery("User by Email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();

        } catch (Exception e) {
            //do something clever here
        }
        return user;
    }

    public List<User> all() {
        return db.createNamedQuery("All Users", User.class)
                .getResultList();
    }
}
