package com.jamchae.devdev.repository;

import com.jamchae.devdev.domain.User;
import jakarta.persistence.EntityManager;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }
}
