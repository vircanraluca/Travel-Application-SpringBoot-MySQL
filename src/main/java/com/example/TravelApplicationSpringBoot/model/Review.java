package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "reviews",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_rev_user_pkg",
                columnNames = {"user_id", "package_id"}  // un user, o recenzie per pachet
        )
)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK → users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // FK → tourist_packages
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private TouristPackage touristPackage;

    // CHECK (1-5) e în BD, validarea @Min/@Max e în Service/DTO
    @Column(nullable = false)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ── Constructori ──────────────────────────────────────────
    public Review() {}

    public Review(User user, TouristPackage touristPackage, Integer rating, String comment) {
        this.user          = user;
        this.touristPackage = touristPackage;
        this.rating        = rating;
        this.comment       = comment;
    }

    // ── Getters & Setters ─────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TouristPackage getTouristPackage() { return touristPackage; }
    public void setTouristPackage(TouristPackage touristPackage) { this.touristPackage = touristPackage; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Review{id=" + id + ", rating=" + rating + "}";
    }
}
