package com.jamchae.devdev.repository;

import jakarta.persistence.EntityManager;

public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

}
