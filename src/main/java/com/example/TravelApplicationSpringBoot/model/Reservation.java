package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK → users (clientul care a rezervat)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // FK → tourist_packages
    // Câmpul se numește "touristPackage" și îl referențiezi cu mappedBy în TouristPackage
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private TouristPackage touristPackage;

    @Column(name = "number_of_persons", nullable = false)
    private Integer numberOfPersons;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ReservationStatus status = ReservationStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    @Column(name = "reservation_date", updatable = false)
    private LocalDateTime reservationDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    // Relație 1:1 cu Payment
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    @PrePersist
    protected void onCreate() {
        this.reservationDate = LocalDateTime.now();
    }

    // ── Enum-uri ──────────────────────────────────────────────
    public enum ReservationStatus {
        PENDING, CONFIRMED, CANCELLED, COMPLETED
    }

    public enum PaymentStatus {
        UNPAID, PAID, REFUNDED
    }

    // ── Constructori ──────────────────────────────────────────
    public Reservation() {}

    // ── Getters & Setters ─────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TouristPackage getTouristPackage() { return touristPackage; }
    public void setTouristPackage(TouristPackage touristPackage) { this.touristPackage = touristPackage; }

    public Integer getNumberOfPersons() { return numberOfPersons; }
    public void setNumberOfPersons(Integer numberOfPersons) { this.numberOfPersons = numberOfPersons; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDateTime getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", status=" + status + ", paymentStatus=" + paymentStatus + "}";
    }
}