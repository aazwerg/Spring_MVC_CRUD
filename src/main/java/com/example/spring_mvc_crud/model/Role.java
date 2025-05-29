package com.example.spring_mvc_crud.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private ALLNAMES name;

    public enum ALLNAMES {
        ROLE_ADMIN("ROLE_ADMIN"),
        ROLE_USER("ROLE_USER");

        private final String title;

        ALLNAMES(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public Role() {
    }

    public Role(ALLNAMES name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ALLNAMES getName() {
        return name;
    }

    public void setName(ALLNAMES name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}

