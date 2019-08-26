package com.mabellou.immobil.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private Home(){ }

    public Home(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(id, home.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
