package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapăm ENUM-ul din MySQL cu ENUM-ul din Java
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 20)
    private RoleName name;

    // ── Enum ──────────────────────────────────────────────────
    public enum RoleName {
        CLIENT, AGENT, ADMIN
    }

    // ── Constructori ──────────────────────────────────────────
    public Role() {}

    public Role(RoleName name) {
        this.name = name;
    }

    // ── Getters & Setters ─────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public RoleName getName() { return name; }
    public void setName(RoleName name) { this.name = name; }

    @Override
    public String toString() {
        return "Role{id=" + id + ", name=" + name + "}";
    }
}